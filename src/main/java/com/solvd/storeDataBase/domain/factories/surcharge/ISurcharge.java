package com.solvd.storeDataBase.domain.factories.surcharge;

import com.solvd.storeDataBase.domain.Product;

public interface ISurcharge {

    public Product apply(Product product);
}
