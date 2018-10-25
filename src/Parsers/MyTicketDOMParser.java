package Parsers;

import Essences.Passenger;
import Essences.Ticket;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyTicketDOMParser {
    private String xmlFileName = "";
    private String xsdFileName = "";
    private HashMap<String, String> atributes = new HashMap<>();
    private List<String> attributeNames = new ArrayList<>();

    public  MyTicketDOMParser(String xmlFileName, String xsdFileName) {
        this.xmlFileName = xmlFileName;
        this.xsdFileName = xsdFileName;
    }
    public void parse(List<Ticket> tickets) {
        try {
            File xmlFile = new File(this.xmlFileName);
            File xsdFile = new File(this.xsdFileName);

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsdFile);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setSchema(schema);
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            if (doc.hasChildNodes()) {
                NodeList nodeList = doc.getElementsByTagName("ticket");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        atributes.clear();
                        this.attributeNames = Ticket.getAttributeNames();
                        for (String fieldName : this.attributeNames) {
                            atributes.put(fieldName, element.getElementsByTagName(fieldName).item(0).getTextContent());
                        }
                        tickets.add(new Ticket(atributes));
                        if (((Element) node).getElementsByTagName("passenger").getLength() != 0) {
                            element = (Element) ((Element) node).getElementsByTagName("passenger").item(0);
                            this.attributeNames = Passenger.getAttributeNames();
                            atributes.clear();
                            for (String fieldName : this.attributeNames) {
                                atributes.put(fieldName, element.getElementsByTagName(fieldName).item(0).getTextContent());
                            }
                            tickets.get(tickets.size() - 1).addPassenger(new Passenger(atributes));
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            Logger.getLogger(MyTicketDOMParser.class.getName())
                    .log(Level.SEVERE, null, e);
        }
    }
}
