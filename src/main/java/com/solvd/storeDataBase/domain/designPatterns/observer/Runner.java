package com.solvd.storeDataBase.domain.designPatterns.observer;

import com.solvd.storeDataBase.domain.Address;
import com.solvd.storeDataBase.domain.designPatterns.builders.ProductWithBuilder;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args){
        Subscriber subs1 = new Subscriber(1L,"First subscriber",new Address("Add",123));
        Subscriber subs2 = new Subscriber(2L,"Second subscriber",new Address("Add",124));
        Subscriber subs3 = new Subscriber(1L,"Third subscriber",new Address("Add",200));

        ProductWithBuilder product = new ProductWithBuilder.Builder(20L,"Diet Coke").addPrice(BigDecimal.valueOf(22)).build();
        // Add two subscribers to stock changing alerts
        product.addSubscriber(subs1);
        product.addSubscriber(subs3);

        product.setStock(10);
        product.setStock(9);
        product.setStock(8);

        product.setStock(0);

    }
}
