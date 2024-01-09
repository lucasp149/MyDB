package com.solvd.storeDataBase.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order extends GeneralEntity{
    private Long id;
    private Date date;
    private Payment payment;
    private Client client;
    private Store store;
    private List<Product> products;
    private List<Integer> quantities;
    public Order() {
    }

    public Order(Long id, Date date) {
        this.id = id;
        this.date = date;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }


    // METHODS

    public BigDecimal getTotal(){
        BigDecimal total = new BigDecimal(0);
        List<Product> products = getProducts();
        List<Integer> quantities = getQuantities();

        for(int i = 0;i<products.size();i++){
            BigDecimal q = new BigDecimal(quantities.get(i));
            total = total.add(products.get(i).getPrice().multiply(q));
        }
        return total;
    }

    // HELPERS

    @Override
    public String toString() {
        return "-------------------- Order --------------------" + "\n" +
                "* id=" + id + "\n" +
                "* date=" + date +"\n" +
                "* payment=" + payment +"\n" +
                "* client=" + client +"\n" +
                "* store=" + store +"\n" +
                "* " + products +"\n" +
                "-------------------------------------"+
                "* " + quantities +"\n" +
                "-------------------------------------";
    }
}
