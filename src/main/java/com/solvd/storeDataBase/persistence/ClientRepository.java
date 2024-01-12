package com.solvd.storeDataBase.persistence;

import com.solvd.storeDataBase.domain.Client;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface ClientRepository extends GeneralRepository<Client> {
    @Override
    void updateById(@Param("id") Long id,@Param("client") Client client) throws SQLException;

    @Override
    Long create(Client client) throws SQLException;

    Client checkPassport(String number);
}
