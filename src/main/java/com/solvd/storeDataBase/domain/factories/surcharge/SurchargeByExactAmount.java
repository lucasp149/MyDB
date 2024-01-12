package com.solvd.storeDataBase.domain.factories.surcharge;

import com.solvd.storeDataBase.domain.Product;

import java.math.BigDecimal;

public class SurchargeByExactAmount extends Surcharge{
    BigDecimal amount;

    public SurchargeByExactAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public Product apply(Product product) {
        Product changedProduct = new Product(product);
        BigDecimal currentPrice = changedProduct.getPrice();
        BigDecimal newPrice = currentPrice.add(amount);
        changedProduct.setPrice(newPrice);
        return changedProduct;
    }
}
