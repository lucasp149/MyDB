package com.solvd.storeDataBase.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product extends GeneralEntity implements SecondaryEntity<Deposit>, ThirdEntity<Category> {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Deposit deposit;
    private Category category;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal price) {
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
    }

    public Product(String name, String description, BigDecimal price, Deposit deposit, Category category) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setDeposit(deposit);
        setCategory(category);
    }
    public Product(String name, String description, BigDecimal price) {
        setName(name);
        setDescription(description);
        setPrice(price);
    }

    public Product(String name) {
        setName(name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public void setSecondaryEntity(Deposit deposit) {
        setDeposit(deposit);
    }

    @Override
    public void setThirdEntity(Category category) {
        setCategory(category);
    }

    @Override
    public String toString() {
        return "-------------- PRODUCT -------------- " +'\n'+
                "** id=" + id +'\n' +
                "** name='" + name + '\n' +
                "** price=" + price + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
