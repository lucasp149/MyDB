package com.solvd.storeDataBase.parser;

import com.solvd.storeDataBase.domain.City;
import com.solvd.storeDataBase.domain.Client;
import com.solvd.storeDataBase.domain.Product;
import com.solvd.storeDataBase.domain.Zone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ParserClass {

    ;
    protected static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] arg) {

        LOGGER.info("DOM PARSER");

        Zone zone = ParserLibrary.parseToZone("J:\\JAVA automation\\DataBases\\MyDb_mybatis\\src\\main\\resources\\Xml\\zone.xml");
        City city = ParserLibrary.parseToCity("J:\\JAVA automation\\DataBases\\MyDb_mybatis\\src\\main\\resources\\Xml\\city.xml");

        LOGGER.info(zone);
        LOGGER.info(city);


        LOGGER.info("END OF DOM PARSER");

        LOGGER.info("SAX PARSER");

        File fileReference = new File("J:\\JAVA automation\\DataBases\\MyDb_mybatis\\src\\main\\resources\\Xml\\client.xml");
        SaxHandlerClient handler = new SaxHandlerClient();
        try {
            ParserLibrary.SAXParser(fileReference, handler);
            Client client = handler.getResult();
            System.out.println(client);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("END OF SAX PARSER");

        LOGGER.info("StAX PARSER");

        File secondFileReference = new File("J:\\JAVA automation\\DataBases\\MyDb_mybatis\\src\\main\\resources\\Xml\\city.xml");

        LOGGER.info(ParserLibrary.StAXParserCity(secondFileReference));

        LOGGER.info("END OF StAX PARSER");

        LOGGER.info("JAXB PARSER");

        File JAXBFileReference = new File("J:\\JAVA automation\\DataBases\\MyDb_mybatis\\src\\main\\resources\\Xml\\zone.xml");

        ParserLibrary<Zone> zoneParser = new ParserLibrary<>();
        try {
            LOGGER.info(zoneParser.JAXBParser(JAXBFileReference,com.solvd.storeDataBase.domain.Zone.class));
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        File cityFileReference = new File("J:\\JAVA automation\\DataBases\\MyDb_mybatis\\src\\main\\resources\\Xml\\city.xml");

        ParserLibrary<City> cityParser = new ParserLibrary<>();

        try {
            LOGGER.info(cityParser.JAXBParser(cityFileReference, City.class));
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        File clientFileReference = new File("J:\\JAVA automation\\DataBases\\MyDb_mybatis\\src\\main\\resources\\Xml\\client.xml");

        ParserLibrary<Client> clientParser = new ParserLibrary<>();

        try {
            LOGGER.info(clientParser.JAXBParser(clientFileReference, Client.class));
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        File productFileReference = new File("J:\\JAVA automation\\DataBases\\MyDb_mybatis\\src\\main\\resources\\Xml\\product.xml");

        ParserLibrary<Product> productParser = new ParserLibrary<>();

        try {
            LOGGER.info(productParser.JAXBParser(productFileReference, Product.class));
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("END OF JAXB PARSER");


        LOGGER.info("JACKSON PARSER");

        productFileReference = new File("src/main/resources/Jsons/product.json");

        try {
            LOGGER.info(productParser.jacksonParser(productFileReference,Product.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        LOGGER.info("END OF JACKSON PARSER");

    }
}
