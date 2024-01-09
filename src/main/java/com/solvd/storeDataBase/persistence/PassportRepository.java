package com.solvd.storeDataBase.persistence;

import com.solvd.storeDataBase.domain.Passport;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface PassportRepository extends GeneralRepository<Passport> {
    @Override
    void updateById(@Param("id") Long id,@Param("passport") Passport passport) throws SQLException;

    // adds the find by number method. Its gonna be useful to prevent creating new Clients with the same passport
    Passport getByNumber(String number);
}
