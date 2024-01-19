package com.solvd.storeDataBase.domain.designPatterns.builders;

import com.solvd.storeDataBase.domain.Category;
import com.solvd.storeDataBase.domain.Deposit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class RunnerBuilder {
    protected static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        ProductWithBuilder product = new ProductWithBuilder.Builder(50L, "Burguer").addCategory(new Category("F. Food")).addDeposit(new Deposit("F. Food Deposit")).addDescription("This is the best hamburger you will ever taste").addPrice(BigDecimal.valueOf(20)).build();

    }
}
