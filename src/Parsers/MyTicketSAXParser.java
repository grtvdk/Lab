package Parsers;

import Essences.Passenger;
import Essences.Ticket;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTicketSAXParser extends DefaultHandler implements MySAXParser {
    private SAXParserFactory factory = SAXParserFactory.newInstance();
    private List<Ticket> tickets = new ArrayList<>();
    private String xmlFileName = "";
    private String xsdFileName = "";
    private boolean writeAttribures = false;
    private String currentField = "";
    private String currentClass = "";
    private HashMap<String, String> attributes = new HashMap<>();

    public MyTicketSAXParser(List<Ticket> tickets, String xmlFileName, String xsdFileName) throws SAXException {
        this.tickets = tickets;
        this.xmlFileName = xmlFileName;
        this.xsdFileName = xsdFileName;
        File xsdFile = new File(this.xsdFileName);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(xsdFile);
        factory.setNamespaceAware(true);
        factory.setSchema(schema);
    }
    @Override
    public void startDocument() {}
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        if (qName == "ticket" || qName == "passenger") {
            currentClass = qName;
            this.writeAttribures = true;
        }
        else
            currentField = qName;
    }
    @Override
    public void characters(char[] ch, int start, int length) {
        if (this.writeAttribures) {
            attributes.put(currentField, new String(ch, start, length));
        }
    }
    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if (qName.equals(currentClass)) {
            switch (currentClass) {
                case "ticket":
                    tickets.add(new Ticket(attributes));
                    System.out.println(1);
                    break;
                case "passenger":
                    tickets.get(tickets.size()-1).addPassenger(new Passenger(attributes));
                    break;
            }
            currentClass = "";
            currentField = "";
            this.writeAttribures = false;
            attributes.clear();
        }
    }
    @Override
    public void endDocument() {}
    @Override
    public  void  parse() throws ParserConfigurationException, SAXException, IOException {
        File xmlFile = new File(this.xmlFileName);
        SAXParser parser = factory.newSAXParser();
        parser.parse(xmlFile, this);
    }
}
