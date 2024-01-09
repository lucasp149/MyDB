package com.solvd.storeDataBase.service.impl;

import com.solvd.storeDataBase.domain.City;
import com.solvd.storeDataBase.persistence.implementation.myBatis.CityRepositoryImplMB;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;
import com.solvd.storeDataBase.service.GeneralServiceImpl;

public class CityServiceImpl extends GeneralServiceImpl<City> {
    @Override
    public GeneralRepositoryImplMB<City> getRepository() {
        return new CityRepositoryImplMB();
    }
}
