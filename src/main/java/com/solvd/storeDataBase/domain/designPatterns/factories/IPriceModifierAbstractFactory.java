package com.solvd.storeDataBase.domain.designPatterns.factories;

import com.solvd.storeDataBase.domain.designPatterns.factories.surcharge.PriceModifierEnum;

import java.math.BigDecimal;

public interface IPriceModifierAbstractFactory {
    public  PriceModifier priceModifier(PriceModifierEnum type, int percentage);
    public PriceModifier priceModifier(PriceModifierEnum type, BigDecimal amount);
}
