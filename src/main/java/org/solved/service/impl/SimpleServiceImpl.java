package org.solved.service.impl;

import org.solved.domain.GeneralEntity;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;

import java.sql.SQLException;

public abstract class SimpleServiceImpl<T extends GeneralEntity> {

    public abstract GeneralRepositoryImplementation<T> getImplementation();

    public abstract T getEntity(String name);


    // MAIN METHODS

    public T create(String name) {
        T entity = null;
        GeneralRepositoryImplementation<T> repository = getImplementation();
        Long id = repository.findByName(name);

        if (id == 0L) {
            try {
                entity = getEntity(name);
                Long entityId = repository.create(entity);
                entity.setId(entityId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                entity = repository.getById(id);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return entity;
    }

    public boolean delete(Long id) {

        GeneralRepositoryImplementation<T> repository = getImplementation();
        try {
            repository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    public boolean update(Long id, T entity) {
        GeneralRepositoryImplementation<T> repository = getImplementation();
        try {
            repository.updateById(id, entity);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public T find (Long id) {
        T entity;
        try {
            entity = getImplementation().getById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

}

