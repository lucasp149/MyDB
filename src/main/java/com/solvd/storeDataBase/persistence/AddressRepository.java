package com.solvd.storeDataBase.persistence;

import com.solvd.storeDataBase.domain.Address;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface AddressRepository extends GeneralRepository<Address> {
    @Override
    void updateById(@Param("id") Long id,@Param("address") Address address) throws SQLException;
}
