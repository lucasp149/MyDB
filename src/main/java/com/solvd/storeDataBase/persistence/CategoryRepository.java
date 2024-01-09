package com.solvd.storeDataBase.persistence;

import com.solvd.storeDataBase.domain.Category;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface CategoryRepository extends GeneralRepository<Category> {
    @Override
    void updateById(@Param("id") Long id,@Param("category") Category category) throws SQLException;
}
