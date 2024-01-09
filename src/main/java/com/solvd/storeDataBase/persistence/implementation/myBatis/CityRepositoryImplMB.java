package com.solvd.storeDataBase.persistence.implementation.myBatis;


import com.solvd.storeDataBase.domain.City;
import com.solvd.storeDataBase.persistence.CityRepository;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import org.apache.ibatis.session.SqlSession;


public class CityRepositoryImplMB extends GeneralRepositoryImplMB<City> implements CityRepository {
    @Override
    public GeneralRepository<City> getRepository(SqlSession session) {
        return session.getMapper(CityRepository.class);
    }

}
