package com.solvd.storeDataBase.persistence;

import com.solvd.storeDataBase.domain.Deposit;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface DepositRepository extends GeneralRepository<Deposit> {
    @Override
    void updateById(@Param("id") Long id,@Param("deposit") Deposit deposit) throws SQLException;
}
