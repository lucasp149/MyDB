package org.solved.service.impl;

import org.solved.domain.Category;
import org.solved.persistence.implementation.CategoryRepositoryImplementation;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;

public class CategoryServiceImpl extends SimpleServiceImpl<Category> {


    @Override
    public GeneralRepositoryImplementation<Category> getImplementation() {
        return new CategoryRepositoryImplementation();
    }

    @Override
    public Category getEntity(String name) {
        return new Category(name);
    }


}
