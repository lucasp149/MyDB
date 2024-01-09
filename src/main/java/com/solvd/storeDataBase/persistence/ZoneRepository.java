package com.solvd.storeDataBase.persistence;

import com.solvd.storeDataBase.domain.Zone;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface ZoneRepository extends GeneralRepository<Zone> {


    public void updateById(@Param("id") Long id, @Param("zone") Zone zone) throws SQLException;

}
