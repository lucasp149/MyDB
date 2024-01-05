package org.solved;

import org.solved.persistence.implementation.AddressRepositoryImplementation;
import org.solved.service.impl.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ZoneServiceImp zoneService = new ZoneServiceImp();
        CityServiceImpl cityService = new CityServiceImpl();
        AddressServiceImpl addressService = new AddressServiceImpl();
        PaymentServiceImpl payments = new PaymentServiceImpl();
        DepositServiceImpl deposits = new DepositServiceImpl();
        StoreServiceImpl stores = new StoreServiceImpl();
        AddressRepositoryImplementation addressRep = new AddressRepositoryImplementation();
        ClientServiceImpl clients = new ClientServiceImpl();
        PassportServiceImpl passports = new PassportServiceImpl();
        ProductServiceImpl products = new ProductServiceImpl();
        CategoryServiceImpl categories = new CategoryServiceImpl();
        /*
        Address newAddress = addressImp.getById(1);
        System.out.println(newAddress.toString());

        ArrayList<Address> allAddresses = addressImp.getAll();
        System.out.println(allAddresses);

        Zone zone = new Zone("Example Zone");
        try {
            Long zoneId = zoneImp.create(zone);
            zone.setId(zoneId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        City city = new City();
        city.setName("Example City");

        try {
            Long cityId = cityImp.create(city, 1L);
            city.setId(cityId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        Address newAddressInserted = new Address("Vicent Street", 144, city);
        Long newAddressId = addressImp.create(newAddressInserted, city.getId());
        System.out.println(newAddressId);
        */

        System.out.println(products.find(4L));
        //System.out.println(addressRep.separateStreetName("Shopping Street II 124"));

    }
}