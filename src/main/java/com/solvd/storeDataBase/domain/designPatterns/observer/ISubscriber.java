package com.solvd.storeDataBase.domain.designPatterns.observer;

public interface ISubscriber {
    public void notifyOutOfStock(String productName);
    public void notifyNewStock(String productName);
}
