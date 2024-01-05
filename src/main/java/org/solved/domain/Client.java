package org.solved.domain;

import java.util.List;

public class Client extends GeneralEntity implements SecondaryEntity<Address>,ThirdEntity<Passport> {
    private Long id;
    private String firstName;
    private String lastName;
    private Address address;
    private Passport passport;
    private List<Order> orders;

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
