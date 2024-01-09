package com.solvd.storeDataBase.persistence;

import com.solvd.storeDataBase.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface ProductRepository extends GeneralRepository<Product>{
    @Override
    void updateById(@Param("id") Long id,@Param("product") Product product) throws SQLException;

    void changePrice (Long id, BigDecimal price);
}
