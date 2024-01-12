package com.solvd.storeDataBase.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.storeDataBase.domain.City;
import com.solvd.storeDataBase.domain.Zone;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.namespace.QName;
import javax.xml.parsers.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ParserLibrary<T> {
    protected static final Logger LOGGER = LogManager.getLogger();

    public static Document readXmlFile(String name) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;

        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(new File(name));
        document.getDocumentElement().normalize();

        return document;
    }

    public static Zone parseToZone(String name) {
        Zone createdObject = new Zone();
        try {
            Document doc = readXmlFile(name);
            NodeList nodes = doc.getElementsByTagName("zone");
            Node node = nodes.item(0);
            Element eElement = (Element) node;

            createdObject.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
            createdObject.setId(Long.parseLong(eElement.getAttribute("id")));


        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return createdObject;
    }

    public static City parseToCity(String name) {
        City createdObject = new City();
        try {
            Document doc = readXmlFile(name);
            NodeList nodes = doc.getElementsByTagName("city");
            Node node = nodes.item(0);
            Element eElement = (Element) node;
            NodeList secondNodes = eElement.getElementsByTagName("zone");
            Node secondNode = secondNodes.item(0);
            Element secondElement = (Element) secondNode;
            Zone zone = new Zone(
                    Long.parseLong(secondElement.getAttribute("id")),
                    secondElement.getElementsByTagName("name").item(0).getTextContent()
            );

            createdObject.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
            createdObject.setId(Long.parseLong(eElement.getAttribute("id")));
            createdObject.setZone(zone);


        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return createdObject;
    }

    public static void SAXParser(File file, DefaultHandler handler) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxFactory.newSAXParser();
        parser.parse(file, handler);
    }

    public static City StAXParserCity(File file) {
        City city = new City();
        Zone zone = new Zone();
        String nodeTag = "";

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fis = new FileInputStream(file)) {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(fis);
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "city":
                            city.setId(Long.parseLong(startElement.getAttributeByName(new QName("id")).getValue()));
                            nodeTag = "city";
                            break;
                        case "name":
                            if (nodeTag.equals("city")) {
                                event = reader.nextEvent();
                                city.setName(event.asCharacters().getData());
                            }
                            if (nodeTag.equals("zone")) {
                                event = reader.nextEvent();
                                zone.setName(event.asCharacters().getData());
                            }

                            break;
                        case "zone":
                            zone.setId(Long.parseLong(startElement.getAttributeByName(new QName("id")).getValue()));
                            nodeTag = "zone";

                    }


                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("zone")) {
                        city.setZone(zone);
                    }
                }

            }
            return city;
        } catch (IOException |
                 XMLStreamException e) {
            throw new RuntimeException(e);
        }


    }

    private T createInstance(Class<T> t) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        return t.getDeclaredConstructor().newInstance();
    }

    public T JAXBParser(File file, Class<T> instanceType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {


        try {
            JAXBContext context = JAXBContext.newInstance(instanceType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(file);


        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public T jacksonParser(File file, Class<T> c) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, c);
    }
}
