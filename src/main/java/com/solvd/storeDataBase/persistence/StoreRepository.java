package com.solvd.storeDataBase.persistence;

import com.solvd.storeDataBase.domain.Store;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface StoreRepository extends GeneralRepository<Store> {
    @Override
    void updateById(@Param("id") Long id,@Param("store") Store store) throws SQLException;
}
