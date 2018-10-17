package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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

public class DomParser
{
    private  String xmlFileName;

    public  DomParser(String xmlFileName)
    {
        this.xmlFileName = xmlFileName;
    }

    public void parse()
    {
        try {

            // Строим объектную модель исходного XML файла
            final File xmlFile = new File(System.getProperty("user.dir")
                    + File.separator + xmlFileName);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);

            // Выполнять нормализацию не обязательно, но рекомендуется
            doc.getDocumentElement().normalize();

            System.out.println("Корневой элемент: "
                    + doc.getDocumentElement().getNodeName());
            System.out.println("============================");

            // Получаем все узлы с именем "staff"
            NodeList nodeList = doc.getElementsByTagName("ticket");

            for (int i = 0; i < nodeList.getLength(); i++)
            {
                // Выводим информацию по каждому из найденных элементов
                Node node = nodeList.item(i);
                System.out.println();
                System.out.println("Текущий элемент: " + node.getNodeName());
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;
                    System.out.println("Carrier: "
                            + element.getElementsByTagName("carrier").item(0)
                            .getTextContent());
                    System.out.println("FlightNum: " + element
                            .getElementsByTagName("flightNum").item(0)
                            .getTextContent());
                    System.out.println("PlaceNum: " + element
                            .getElementsByTagName("placeNum").item(0)
                            .getTextContent());
                    System.out.println("PlaceClass: " + element
                            .getElementsByTagName("placeClass").item(0)
                            .getTextContent());
                    System.out.println("Date: " + element
                            .getElementsByTagName("date").item(0)
                            .getTextContent());
                    System.out.println("Time: " + element
                            .getElementsByTagName("time").item(0)
                            .getTextContent());
                    System.out.println("Status: " + element
                            .getElementsByTagName("status").item(0)
                            .getTextContent());
                    System.out.println("Price: " + element
                            .getElementsByTagName("price").item(0)
                            .getTextContent());
                    System.out.println("Origin: " + element
                            .getElementsByTagName("origin").item(0)
                            .getTextContent());
                    System.out.println("Destination: " + element
                            .getElementsByTagName("destination").item(0)
                            .getTextContent());
                }
            }
        } catch (ParserConfigurationException | SAXException
                | IOException e) {
            Logger.getLogger(DomParser.class.getName())
                    .log(Level.SEVERE, null, e);
        }
    }
}
