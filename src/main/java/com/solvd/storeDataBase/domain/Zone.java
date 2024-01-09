package com.solvd.storeDataBase.domain;

public class Zone extends GeneralEntity {
    private Long id;
    private String name;

    public Zone (){}

    public Zone(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Zone(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Id: "+ this.id+ " Name: "+this.name;
    }
}
