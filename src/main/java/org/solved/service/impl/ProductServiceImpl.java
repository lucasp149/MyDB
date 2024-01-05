package org.solved.service.impl;

import org.solved.domain.Category;
import org.solved.domain.Deposit;
import org.solved.domain.Product;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;
import org.solved.persistence.implementation.ProductRepositoryImplementation;

import java.math.BigDecimal;
import java.sql.SQLException;

public class ProductServiceImpl extends TripleServiceImpl<Product, Deposit, Category>{

    public Product create(String name, String description, BigDecimal price, Deposit deposit, Category category){
           Product temporaryProduct = create(name, deposit, category); // creates it on database without any price or description
           temporaryProduct.setDescription(description);
           temporaryProduct.setPrice(price);

        try {
            getImplementation().updateById(temporaryProduct.getId(),temporaryProduct);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return temporaryProduct;
    };
    @Override
    public SimpleServiceImpl<Deposit> getSecondaryService() {
        return new DepositServiceImpl();
    }

    @Override
    public GeneralRepositoryImplementation<Product> getImplementation() {
        return new ProductRepositoryImplementation();
    }

    @Override
    public Product getEntity(String name) {
        return new Product(name);
    }

    @Override
    public SimpleServiceImpl<Category> getThirdService() {
        return new CategoryServiceImpl();
    }
}
