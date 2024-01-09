package com.solvd.storeDataBase.persistence.implementation.myBatis;

import com.solvd.storeDataBase.ConnectToDbMyBatis;
import com.solvd.storeDataBase.domain.Passport;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import com.solvd.storeDataBase.persistence.PassportRepository;
import org.apache.ibatis.session.SqlSession;


public class PassportRepositoryImplMB extends GeneralRepositoryImplMB<Passport> implements PassportRepository {
    @Override
    public GeneralRepository<Passport> getRepository(SqlSession session) {
        return session.getMapper(PassportRepository.class);
    }

    @Override
    public Passport getByNumber(String number) {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            PassportRepository repository = sqlSession.getMapper(PassportRepository.class);
            return repository.getByNumber(number);
        }
    }
}
