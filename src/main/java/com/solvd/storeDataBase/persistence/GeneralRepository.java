package com.solvd.storeDataBase.persistence;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GeneralRepository<T> {


    T getById (Long id) throws SQLException;

    List<T> getAll () throws SQLException;

    Long create(T t) throws SQLException;

    void updateById (Long id, T t) throws SQLException;

    void deleteById (Long id);


}
