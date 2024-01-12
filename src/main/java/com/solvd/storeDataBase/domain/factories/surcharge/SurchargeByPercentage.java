package com.solvd.storeDataBase.domain.factories.surcharge;

import com.solvd.storeDataBase.domain.Product;

import java.math.BigDecimal;

public class SurchargeByPercentage extends Surcharge {

    int surchargePercentage;

    public SurchargeByPercentage(int surchargePercentage) {
        this.surchargePercentage = surchargePercentage;
    }

    @Override
    public Product apply(Product product) {
        Product changedProduct = new Product(product);
        BigDecimal currentPrice = changedProduct.getPrice();
        BigDecimal surcharge = currentPrice.multiply(BigDecimal.valueOf(surchargePercentage / 100F));
        BigDecimal newPrice = currentPrice.add(surcharge);
        changedProduct.setPrice(newPrice);

        return changedProduct;
    }
}
