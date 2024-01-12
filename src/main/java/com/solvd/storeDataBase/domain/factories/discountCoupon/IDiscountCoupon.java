package com.solvd.storeDataBase.domain.factories.discountCoupon;

import com.solvd.storeDataBase.domain.Product;

public interface IDiscountCoupon {
    public Product apply(Product product) throws exceededDiscountAmountException;



}
