package com.solvd.storeDataBase.persistence;

import com.solvd.storeDataBase.domain.City;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface CityRepository extends GeneralRepository<City> {

    @Override
    void updateById(@Param("id") Long id,@Param("city") City city) throws SQLException;
}
