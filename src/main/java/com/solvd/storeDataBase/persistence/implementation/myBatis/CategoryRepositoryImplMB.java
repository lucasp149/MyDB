package com.solvd.storeDataBase.persistence.implementation.myBatis;

import com.solvd.storeDataBase.domain.Category;
import com.solvd.storeDataBase.persistence.CategoryRepository;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import com.solvd.storeDataBase.persistence.PassportRepository;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class CategoryRepositoryImplMB extends GeneralRepositoryImplMB<Category> implements CategoryRepository {


    @Override
    public GeneralRepository<Category> getRepository(SqlSession session) {
        return  session.getMapper(CategoryRepository.class);
    }
}
