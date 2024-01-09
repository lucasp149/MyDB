package com.solvd.storeDataBase.persistence.implementation.myBatis;

import com.solvd.storeDataBase.domain.Product;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import com.solvd.storeDataBase.persistence.ProductRepository;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;

public class ProductRepositoryImplMB extends GeneralRepositoryImplMB<Product> implements ProductRepository {
    @Override
    public void changePrice(Long id, BigDecimal price) {
    }

    @Override
    public GeneralRepository<Product> getRepository(SqlSession session) {
        return session.getMapper(ProductRepository.class);
    }
}
