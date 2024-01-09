package com.solvd.storeDataBase.persistence;

import com.solvd.storeDataBase.domain.Payment;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface PaymentRepository extends GeneralRepository<Payment> {
    @Override
    void updateById(@Param("id") Long id,@Param("payment") Payment payment) throws SQLException;
}
