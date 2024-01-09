package com.solvd.storeDataBase.service.impl;

import com.solvd.storeDataBase.domain.Passport;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;
import com.solvd.storeDataBase.persistence.implementation.myBatis.PassportRepositoryImplMB;
import com.solvd.storeDataBase.service.GeneralServiceImpl;

public class PassportServiceImpl extends GeneralServiceImpl<Passport> {
    @Override
    public GeneralRepositoryImplMB<Passport> getRepository() {
        return new PassportRepositoryImplMB();
    }
}
