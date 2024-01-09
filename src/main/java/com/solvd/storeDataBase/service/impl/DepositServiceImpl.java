package com.solvd.storeDataBase.service.impl;

import com.solvd.storeDataBase.domain.Deposit;
import com.solvd.storeDataBase.persistence.implementation.myBatis.DepositRepositoryImplMB;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;
import com.solvd.storeDataBase.service.GeneralServiceImpl;

public class DepositServiceImpl extends GeneralServiceImpl<Deposit> {
    @Override
    public GeneralRepositoryImplMB<Deposit> getRepository() {
        return new DepositRepositoryImplMB();
    }
}
