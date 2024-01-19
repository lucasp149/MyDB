package com.solvd.storeDataBase.domain.designPatterns.factories.discountCoupon;

public class exceededDiscountAmountException extends Exception {
    public exceededDiscountAmountException(String message) {
        super(message);
    }
}
