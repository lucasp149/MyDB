package com.solvd.storeDataBase.service.impl;

import com.solvd.storeDataBase.domain.Client;
import com.solvd.storeDataBase.persistence.implementation.myBatis.ClientRepositoryImplMB;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;
import com.solvd.storeDataBase.service.GeneralServiceImpl;

public class ClientServiceImpl extends GeneralServiceImpl<Client> {
    @Override
    public GeneralRepositoryImplMB<Client> getRepository() {
        return new ClientRepositoryImplMB();
    }
}
