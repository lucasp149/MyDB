package com.solvd.storeDataBase.service.impl;

import com.solvd.storeDataBase.domain.Address;
import com.solvd.storeDataBase.persistence.implementation.myBatis.AddressRepositoryImplMB;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;
import com.solvd.storeDataBase.service.GeneralServiceImpl;

public class AddressServiceImpl extends GeneralServiceImpl<Address> {
    @Override
    public GeneralRepositoryImplMB<Address> getRepository() {
        return new AddressRepositoryImplMB();
    }
}
