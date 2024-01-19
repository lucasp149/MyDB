package com.solvd.storeDataBase.domain.designPatterns.observer;

import com.solvd.storeDataBase.domain.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Subscriber implements ISubscriber{

    protected static final Logger LOGGER = LogManager.getLogger();

    Long id;
    String name;
    Address address;

    public Subscriber(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public void notifyOutOfStock(String productName) {
        LOGGER.info(String.format("The product %s is OUT OF STOCK", productName));
    }

    @Override
    public void notifyNewStock(String productName) {
        LOGGER.info(String.format("The product %s has stock again", productName));
    }
}
