package com.solvd.storeDataBase.domain.factories.discountCoupon;

import com.solvd.storeDataBase.domain.Product;

import java.math.BigDecimal;

public class DiscountCouponByPercentage extends DiscountCoupon {

    int discountPercentage;

    public DiscountCouponByPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public Product apply(Product product) {
        Product changedProduct = new Product(product);

        BigDecimal currentPrice = changedProduct.getPrice();
        System.out.println("Current price = " + currentPrice);

        BigDecimal discount = currentPrice.multiply(BigDecimal.valueOf(discountPercentage/100D));
        System.out.println("Discount price = " + discount);
        BigDecimal newPrice = currentPrice.subtract(discount);
        System.out.println("New price = " + newPrice);
        changedProduct.setPrice(newPrice);
        return changedProduct;
    }
}
