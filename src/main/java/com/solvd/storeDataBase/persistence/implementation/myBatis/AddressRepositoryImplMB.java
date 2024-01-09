package com.solvd.storeDataBase.persistence.implementation.myBatis;

import com.solvd.storeDataBase.ConnectToDbMyBatis;
import com.solvd.storeDataBase.domain.Address;
import com.solvd.storeDataBase.persistence.AddressRepository;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class AddressRepositoryImplMB extends GeneralRepositoryImplMB<Address> implements AddressRepository {
    @Override
    public GeneralRepository<Address> getRepository(SqlSession session) {
        return session.getMapper(AddressRepository.class);
    }

}
