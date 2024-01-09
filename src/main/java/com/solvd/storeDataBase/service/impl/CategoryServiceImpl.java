package com.solvd.storeDataBase.service.impl;

import com.solvd.storeDataBase.domain.Category;
import com.solvd.storeDataBase.persistence.implementation.myBatis.CategoryRepositoryImplMB;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;
import com.solvd.storeDataBase.service.GeneralServiceImpl;

public class CategoryServiceImpl extends GeneralServiceImpl<Category> {
    @Override
    public GeneralRepositoryImplMB<Category> getRepository() {
        return new CategoryRepositoryImplMB();
    }
}
