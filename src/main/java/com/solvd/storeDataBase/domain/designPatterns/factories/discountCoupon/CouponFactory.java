package com.solvd.storeDataBase.domain.designPatterns.factories.discountCoupon;

import java.math.BigDecimal;

public class CouponFactory {

    public static DiscountCoupon createCoupon(int percentage) {
        return new DiscountCouponByPercentage(percentage);
    }
    public static DiscountCoupon createCoupon(BigDecimal amount){
        return new DiscountCouponByExactAmount(amount);
    }
}
