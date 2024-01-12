package com.solvd.storeDataBase.parser;

import com.solvd.storeDataBase.domain.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandlerClient extends DefaultHandler {

    private final StringBuilder insideValue = new StringBuilder(); // create an string builder to handle the characters inside each tag

    private String currentNodeTag;
    Client result;
    Address address;
    Passport passport;
    City city;
    Zone zone;

    public Client getResult(){
        return result;
    }

    @Override
    public void startDocument() {
        result = new Client();
        address = new Address();
        passport = new Passport();
        city = new City();
        zone = new Zone();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        insideValue.setLength(0); // reset the string


        if (qName.equalsIgnoreCase("client")) {
            // get tag's attribute by name
            Long id = Long.parseLong(attributes.getValue("id"));
            result.setId(id);
            currentNodeTag = "";
        }
        if (qName.equalsIgnoreCase("address")) {
            // get tag's attribute by name
            Long id = Long.parseLong(attributes.getValue("id"));
            address.setId(id);
            currentNodeTag = "address";
        }
        if (qName.equalsIgnoreCase("passport")) {
            // get tag's attribute by name
            Long id = Long.parseLong(attributes.getValue("id"));
            passport.setId(id);
            currentNodeTag = "passport";
        }
        if (qName.equalsIgnoreCase("zone")) {
            // get tag's attribute by name
            Long id = Long.parseLong(attributes.getValue("id"));
            zone.setId(id);
            currentNodeTag = "zone";
        }
        if (qName.equalsIgnoreCase("city")) {
            // get tag's attribute by name
            Long id = Long.parseLong(attributes.getValue("id"));
            city.setId(id);
            currentNodeTag = "city";
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        insideValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("firstName")) {
            result.setFirstName(insideValue.toString());
        }

        if (qName.equalsIgnoreCase("lastName")) {
            result.setLastName(insideValue.toString());
        }

        if (qName.equalsIgnoreCase("number")) {
            if(currentNodeTag.equals("passport")){
                passport.setNumber(insideValue.toString());
            }
           if(currentNodeTag.equals("address")){
               address.setNumber(Integer.valueOf(insideValue.toString()));
           }
        }

        if (qName.equalsIgnoreCase("name")) {
            if(currentNodeTag.equals("zone")){
                zone.setName(insideValue.toString());
            }
            if(currentNodeTag.equals("city")){
                city.setName(insideValue.toString());
            }
        }

        if (qName.equalsIgnoreCase("streetName")) {
            address.setStreetName(insideValue.toString());
        }

        if (qName.equalsIgnoreCase("passport")) {
            result.setPassport(passport);
        }

        if (qName.equalsIgnoreCase("city")) {
            address.setCity(city);
        }
        if (qName.equalsIgnoreCase("zone")) {
            city.setZone(zone);
        }
        if (qName.equalsIgnoreCase("address")) {
            result.setAddress(address);
        }


    }
}
