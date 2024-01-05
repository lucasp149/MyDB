package org.solved.domain;

public class Deposit extends GeneralEntity implements SecondaryEntity<Address>{
    private Long id;
    private String name;
    private Address address;

    public Deposit(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
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
