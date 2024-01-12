package com.solvd.storeDataBase.domain.factories;

import com.solvd.storeDataBase.domain.Product;
import com.solvd.storeDataBase.domain.exceptions.UnexpectedEnumCase;
import com.solvd.storeDataBase.domain.factories.discountCoupon.DiscountCoupon;
import com.solvd.storeDataBase.domain.factories.discountCoupon.exceededDiscountAmountException;
import com.solvd.storeDataBase.domain.factories.surcharge.PriceModifierEnum;
import com.solvd.storeDataBase.domain.factories.surcharge.Surcharge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class Runner {
    protected static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args){

        Product product = new Product("Practice Product","description", BigDecimal.valueOf(180));

        try {
            DiscountCoupon discountCoupon = (DiscountCoupon) PriceModifierAbstractFactory.createPriceModifier(PriceModifierEnum.DISCOUNT,20);
            Surcharge surcharge = (Surcharge) PriceModifierAbstractFactory.createPriceModifier(PriceModifierEnum.SURCHARGE,BigDecimal.valueOf(150));

            Product discountProduct = discountCoupon.apply(product);
            Product surchargedProduct = surcharge.apply(product);
            LOGGER.info(String.format("This is the product price with discount: %.2f",discountProduct.getPrice().doubleValue()));
            LOGGER.info(String.format("This is the product price with surcharge: %.2f",surchargedProduct.getPrice().doubleValue()));

        } catch (UnexpectedEnumCase | exceededDiscountAmountException e) {
            throw new RuntimeException(e);
        }




    }
}
