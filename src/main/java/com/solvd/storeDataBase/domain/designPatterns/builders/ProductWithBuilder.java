package com.solvd.storeDataBase.domain.designPatterns.builders;

import com.solvd.storeDataBase.domain.Category;
import com.solvd.storeDataBase.domain.Deposit;
import com.solvd.storeDataBase.domain.designPatterns.observer.Subscriber;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductWithBuilder {
    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Deposit deposit;
    private final Category category;
    // add a new attribute
    private int stock;
    // add a subscriber List
    private List<Subscriber> subscribers;

    private ProductWithBuilder(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.deposit = builder.deposit;
        this.category = builder.category;
        this.stock = builder.stock;
        this.subscribers = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public Category getCategory() {
        return category;
    }

    public void setStock(int stock) {
        if (stock == 0) {
            alertSubscribersOutOfStock();
        }
        if(this.stock == 0 && stock > 0){
            alertSubscribersNewStock();
        }
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    private void alertSubscribersOutOfStock() {
        subscribers.forEach(s -> s.notifyOutOfStock(this.name));
    }

    public void alertSubscribersNewStock() {
        subscribers.forEach(s -> s.notifyNewStock(this.name));
    }

    @Override
    public String toString() {
        return "-------------- PRODUCT -------------- " + '\n' +
                "** id=" + id + '\n' +
                "** name='" + name + '\n' +
                "** price=" + price + '\n'
                + "** deposit=" + deposit + "\n"
                + "** category" + category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductWithBuilder product = (ProductWithBuilder) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public static class Builder {
        private final Long id;
        private final String name;
        private String description;
        private BigDecimal price;
        private Deposit deposit;
        private Category category;
        private final int stock;

        public Builder(Long id, String name) {
            this.id = id;
            this.name = name;
            this.stock = 0;
        }

        public Builder addDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder addPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder addDeposit(Deposit deposit) {
            this.deposit = deposit;
            return this;
        }

        public Builder addCategory(Category category) {
            this.category = category;
            return this;
        }


        public ProductWithBuilder build() {
            return new ProductWithBuilder(this);
        }

    }
}


