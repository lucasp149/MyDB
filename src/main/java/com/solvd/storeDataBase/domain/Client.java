package com.solvd.storeDataBase.domain;

import com.solvd.storeDataBase.domain.interfaces.SecondaryEntity;
import com.solvd.storeDataBase.domain.interfaces.ThirdEntity;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name="client")
public class Client extends GeneralEntity implements SecondaryEntity<Address>, ThirdEntity<Passport> {
    @XmlAttribute(name = "id")
    private Long id;
    private String firstName;
    private String lastName;
    private Address address;
    private Passport passport;
    private List<Order> orders;

    public Client() {
    }

    public Client(String firstName, String lastName, Address address, Passport passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.passport = passport;
    }

    public Client (Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client( String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + this.id +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", address=" + this.address +
                ", passport=" + this.passport +
                '}';
    }

    @Override
    public void setSecondaryEntity(Address address) {
        setAddress(address);
    }

    @Override
    public void setThirdEntity(Passport passport) {
        setPassport(passport);
    }
}
