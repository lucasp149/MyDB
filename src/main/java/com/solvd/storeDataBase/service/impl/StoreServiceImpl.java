package com.solvd.storeDataBase.service.impl;

import com.solvd.storeDataBase.domain.Store;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;
import com.solvd.storeDataBase.persistence.implementation.myBatis.StoreRepositoryImplMB;
import com.solvd.storeDataBase.service.GeneralServiceImpl;

public class StoreServiceImpl extends GeneralServiceImpl<Store> {
    @Override
    public GeneralRepositoryImplMB<Store> getRepository() {
        return new StoreRepositoryImplMB();
    }
}
