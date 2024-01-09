package com.solvd.storeDataBase.persistence.implementation.myBatis;

import com.solvd.storeDataBase.domain.Store;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import com.solvd.storeDataBase.persistence.StoreRepository;
import org.apache.ibatis.session.SqlSession;

public class StoreRepositoryImplMB extends GeneralRepositoryImplMB<Store> implements StoreRepository{
    @Override
    public GeneralRepository<Store> getRepository(SqlSession session) {
        return session.getMapper(StoreRepository.class);
    }
}
