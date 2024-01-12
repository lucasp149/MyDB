package com.solvd.storeDataBase.domain;

import com.solvd.storeDataBase.domain.interfaces.SecondaryEntity;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="deposit")
public class Deposit extends GeneralEntity implements SecondaryEntity<Address> {
    @XmlAttribute(name="id")
    private Long id;
    private String name;
    private Address address;

    public Deposit() {
    }

    public Deposit(String name) {
        this.name = name;
    }
    public Deposit (Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Deposit (Long id, String name, Address address) {
        this.address = address;
        this.id = id;
        this.name = name;
    }

    public Deposit (String name, Address address) {
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public void setSecondaryEntity(Address address){
        this.address = address;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
