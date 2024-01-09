package com.solvd.storeDataBase.domain;

public class Payment extends GeneralEntity {
    private Long id;
    private String type;

    public Payment() {
    }

    public Payment (String type){
        this.type = type;
    }
    public Payment (Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
