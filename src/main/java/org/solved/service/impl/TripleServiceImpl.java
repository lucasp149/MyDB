package org.solved.service.impl;

import org.solved.domain.GeneralEntity;
import org.solved.domain.SecondaryEntity;
import org.solved.domain.ThirdEntity;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;

import java.sql.SQLException;

public abstract class TripleServiceImpl<T extends GeneralEntity & SecondaryEntity<V> & ThirdEntity<W>,V extends GeneralEntity,W extends GeneralEntity> extends DoubleServiceImpl<T,V> {

    public abstract SimpleServiceImpl<W> getThirdService();

    public T create(String name, V secondaryEntity, W thirdEntity) {

        GeneralRepositoryImplementation<T> repository = getImplementation();
        SimpleServiceImpl<V> secondaryService = getSecondaryService();
        SimpleServiceImpl<W> thirdService = getThirdService();
        V checkedSecondaryEntity = secondaryService.create(secondaryEntity.getName());
        W checkedThirdEntity = thirdService.create(thirdEntity.getName());
        Long id = repository.findByName(name);
        T entity;

        if (id == 0L) {
            try {
                entity = getEntity(name);
                entity.setSecondaryEntity(checkedSecondaryEntity);
                entity.setThirdEntity(checkedThirdEntity);
                Long entityId = repository.create(entity);
                entity.setId(entityId);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                entity = repository.getById(id);
                entity.setSecondaryEntity(checkedSecondaryEntity);
                entity.setThirdEntity(checkedThirdEntity);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return entity;
    }
    @Override
    public T find(Long id) {
        T entity;

        SimpleServiceImpl<V> secondaryService = getSecondaryService();
        SimpleServiceImpl<W> thirdService = getThirdService();
        V secondaryEntity = secondaryService.find(getImplementation().getSecondaryEntityId(id));
        W thirdEntity = thirdService.find(getImplementation().getThirdEntityId(id));
        try {
            entity = getImplementation().getById(id);
            entity.setSecondaryEntity(secondaryEntity);
            entity.setThirdEntity(thirdEntity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

}
