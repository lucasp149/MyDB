package com.solvd.storeDataBase.domain.designPatterns.factories;

import com.solvd.storeDataBase.domain.designPatterns.factories.discountCoupon.CouponFactory;
import com.solvd.storeDataBase.domain.designPatterns.factories.surcharge.PriceModifierEnum;
import com.solvd.storeDataBase.domain.exceptions.UnexpectedEnumCase;
import com.solvd.storeDataBase.domain.designPatterns.factories.surcharge.SurchargeFactory;

import java.math.BigDecimal;

public abstract class PriceModifierAbstractFactory {


    public static PriceModifier createPriceModifier(PriceModifierEnum type, int percentage) throws UnexpectedEnumCase {
        if (type.name().equals("DISCOUNT")) {
            return CouponFactory.createCoupon(percentage);
        }
        else if (type.name().equals("SURCHARGE")) {
            return SurchargeFactory.createSurcharge(percentage);
        }
        else{
            throw new UnexpectedEnumCase("This Enum doesn't exists");
        }
    }


    public static PriceModifier createPriceModifier(PriceModifierEnum type, BigDecimal amount) throws UnexpectedEnumCase {
        if (type.name().equals("DISCOUNT")) {
            return CouponFactory.createCoupon(amount);
        }
        else if (type.name().equals("SURCHARGE")) {
            return SurchargeFactory.createSurcharge(amount);
        }
        else{
            throw new UnexpectedEnumCase("This Enum doesn't exists");
        }
    }
}
