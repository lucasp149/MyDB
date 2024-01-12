package com.solvd.storeDataBase.domain.factories.surcharge;

import java.math.BigDecimal;

public class SurchargeFactory {

    public static Surcharge createSurcharge(int percentage) {
        return new SurchargeByPercentage(percentage);
    }

    public static Surcharge createSurcharge(BigDecimal amount){
        return new SurchargeByExactAmount(amount);
    }

}
