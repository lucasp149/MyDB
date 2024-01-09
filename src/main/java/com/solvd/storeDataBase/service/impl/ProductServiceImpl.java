package com.solvd.storeDataBase.service.impl;

import com.solvd.storeDataBase.domain.Product;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;
import com.solvd.storeDataBase.persistence.implementation.myBatis.ProductRepositoryImplMB;
import com.solvd.storeDataBase.service.GeneralServiceImpl;

public class ProductServiceImpl extends GeneralServiceImpl<Product> {
    @Override
    public GeneralRepositoryImplMB<Product> getRepository() {
        return new ProductRepositoryImplMB();
    }
}
