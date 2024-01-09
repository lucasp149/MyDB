package com.solvd.storeDataBase.persistence.implementation.myBatis;

import com.solvd.storeDataBase.ConnectToDbMyBatis;
import com.solvd.storeDataBase.domain.Zone;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import com.solvd.storeDataBase.persistence.ZoneRepository;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class ZoneRepositoryImplMB extends GeneralRepositoryImplMB<Zone> implements ZoneRepository {

    @Override
    public GeneralRepository<Zone> getRepository(SqlSession session) {
        return session.getMapper(ZoneRepository.class);
    }


}
