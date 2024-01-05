package org.solved.service.impl;

import org.solved.domain.GeneralEntity;
import org.solved.domain.SecondaryEntity;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;

import java.sql.SQLException;

public abstract class DoubleServiceImpl<T extends GeneralEntity & SecondaryEntity<V>, V extends GeneralEntity> extends SimpleServiceImpl<T> {

    public abstract SimpleServiceImpl<V> getSecondaryService();

    // This method is used when secondary service is a DoubleService
    @Override
    public T create(String name) {
        T entity = null;
        GeneralRepositoryImplementation<T> repository = getImplementation();
        Long id = repository.findByName(name);

        SimpleServiceImpl<V> secondaryService = getSecondaryService();



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
                Long secondary = repository.getSecondaryEntityId(id);
                entity.setSecondaryEntity(secondaryService.find(secondary));

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return entity;
    }

    public T create(String name, V secondaryEntity) {

        GeneralRepositoryImplementation<T> repository = getImplementation();
        SimpleServiceImpl<V> secondaryService = getSecondaryService();

        V checkedSecondaryEntity = secondaryService.create(secondaryEntity.getName());

        Long id = repository.findByName(name);
        T entity;

        if (id == 0L) {
            try {
                entity = getEntity(name);
                entity.setSecondaryEntity(checkedSecondaryEntity);
                Long entityId = repository.create(entity);
                entity.setId(entityId);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                entity = repository.getById(id);
                entity.setSecondaryEntity(checkedSecondaryEntity);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return entity;
    }

    public T find(Long id) {
        T entity;

        SimpleServiceImpl<V> secondaryService = getSecondaryService();
        V secondaryEntity = secondaryService.find(getImplementation().getSecondaryEntityId(id));

        try {
            entity = getImplementation().getById(id);
            entity.setSecondaryEntity(secondaryEntity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

}
