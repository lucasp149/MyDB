package com.solvd.storeDataBase;

import com.solvd.storeDataBase.persistence.OrderRepository;
import com.solvd.storeDataBase.persistence.implementation.myBatis.OrderRepositoryImplMB;
import com.solvd.storeDataBase.service.impl.OrderServiceImpl;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        OrderRepository orderRep = new OrderRepositoryImplMB();
        OrderServiceImpl orders = new OrderServiceImpl();

        System.out.println(orders.get(1L));
        int currentQ = orderRep.getProductQuantity(1L,9L);
        System.out.println(currentQ);

        /*
        try {


            System.out.println(thisRep.getAll());
            System.out.println("CREATE --------------------------");
            Long thisId = thisRep.create(new Address("OOOOOO",1111,secondRep.getById(1L)));
            System.out.println(thisRep.getAll());
            System.out.println("UPDATE --------------------------");
            thisRep.updateById(thisId,new Address("1111111",2222,secondRep.getById(1L)));
            System.out.println(thisRep.getAll());
            System.out.println("DELETE --------------------------");
            thisRep.deleteById(thisId);
            System.out.println(thisRep.getAll());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */




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

        //System.out.println(products.find(4L));
        //System.out.println(addressRep.separateStreetName("Shopping Street II 124"));

    }
}