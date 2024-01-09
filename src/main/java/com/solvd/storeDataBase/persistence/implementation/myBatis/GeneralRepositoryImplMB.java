package com.solvd.storeDataBase.persistence.implementation.myBatis;

import com.solvd.storeDataBase.ConnectToDbMyBatis;
import com.solvd.storeDataBase.domain.GeneralEntity;
import com.solvd.storeDataBase.domain.Passport;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import com.solvd.storeDataBase.persistence.PassportRepository;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public abstract class GeneralRepositoryImplMB<T extends GeneralEntity> implements GeneralRepository<T> {

    public abstract GeneralRepository<T> getRepository(SqlSession session);

    @Override
    public T getById(Long id) throws SQLException {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            GeneralRepository<T> repository = getRepository(sqlSession);
            return repository.getById(id);
        }
    }

    @Override
    public List<T> getAll() throws SQLException {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            GeneralRepository<T> repository = getRepository(sqlSession);
            return repository.getAll();
        }
    }

    @Override
    public Long create(T t) throws SQLException {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            GeneralRepository<T> repository = getRepository(sqlSession);
            repository.create(t);
            return t.getId();
        }
    }

    @Override
    public void updateById(Long id, T t) throws SQLException {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            GeneralRepository<T> repository = getRepository(sqlSession);
            repository.updateById(id,t);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            GeneralRepository<T> repository = getRepository(sqlSession);
            repository.deleteById(id);
        }
    }
}
