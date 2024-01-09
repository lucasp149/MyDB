package com.solvd.storeDataBase.persistence.implementation.myBatis;

import com.solvd.storeDataBase.domain.Deposit;
import com.solvd.storeDataBase.persistence.AddressRepository;
import com.solvd.storeDataBase.persistence.DepositRepository;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class DepositRepositoryImplMB extends GeneralRepositoryImplMB<Deposit> implements DepositRepository {
    @Override
    public GeneralRepository<Deposit> getRepository(SqlSession session) {
        return session.getMapper(DepositRepository.class);
    }


}
