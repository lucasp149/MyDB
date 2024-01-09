package com.solvd.storeDataBase.service;

import com.solvd.storeDataBase.domain.GeneralEntity;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;

import java.sql.SQLException;

public abstract class GeneralServiceImpl<V extends GeneralEntity> implements GeneralService<V> {

    public abstract GeneralRepositoryImplMB<V> getRepository();

    @Override
    public void create(V v) {
        GeneralRepositoryImplMB<V> repository = getRepository();
        try {
            repository.create(v);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        GeneralRepositoryImplMB<V> repository = getRepository();
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, V v) {
        GeneralRepositoryImplMB<V> repository = getRepository();
        try {
            repository.updateById(id,v);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public V get(Long id) {
        GeneralRepositoryImplMB<V> repository = getRepository();
        try {
            return repository.getById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
