package com.solvd.storeDataBase.persistence.implementation.myBatis;

import com.solvd.storeDataBase.ConnectToDbMyBatis;
import com.solvd.storeDataBase.domain.Payment;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import com.solvd.storeDataBase.persistence.PaymentRepository;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class PaymentRepositoryImplMB extends GeneralRepositoryImplMB<Payment> implements PaymentRepository {
    @Override
    public GeneralRepository<Payment> getRepository(SqlSession session) {
        return session.getMapper(PaymentRepository.class);
    }

}
