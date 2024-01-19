package com.solvd.storeDataBase.domain.designPatterns.factories.discountCoupon;

import com.solvd.storeDataBase.domain.Product;

import java.math.BigDecimal;

public class DiscountCouponByExactAmount extends DiscountCoupon{
    BigDecimal amount;

    public DiscountCouponByExactAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public Product apply(Product product) throws exceededDiscountAmountException {
        Product changedProduct = new Product(product);
        BigDecimal currentPrice = changedProduct.getPrice();
        if(amount.compareTo(currentPrice) > 0){
            throw new exceededDiscountAmountException("The current price is bigger than the coupon amount");
        }
        BigDecimal newPrice = currentPrice.subtract(amount);
        changedProduct.setPrice(newPrice);
        return changedProduct;
    }
}
