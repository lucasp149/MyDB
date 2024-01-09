package com.solvd.storeDataBase.service.impl;

import com.solvd.storeDataBase.domain.Payment;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;
import com.solvd.storeDataBase.persistence.implementation.myBatis.PaymentRepositoryImplMB;
import com.solvd.storeDataBase.service.GeneralServiceImpl;

public class PaymentServiceImpl extends GeneralServiceImpl<Payment> {
    @Override
    public GeneralRepositoryImplMB<Payment> getRepository() {
        return new PaymentRepositoryImplMB();
    }
}
