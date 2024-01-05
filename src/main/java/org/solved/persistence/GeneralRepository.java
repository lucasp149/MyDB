package org.solved.persistence;

import java.sql.SQLException;
import java.util.List;

public interface GeneralRepository<T> {

    T getById (Long id) throws SQLException;

    List<T> getAll () throws SQLException;

    Long create(T t) throws SQLException;

    void updateById (Long id, T t) throws SQLException;

    void deleteById (Long id);

    Long findByName (String name);

    Long getSecondaryEntityId (Long entityId);


    Long getThirdEntityId(Long entityId);
}
