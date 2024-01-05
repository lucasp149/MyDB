package org.solved.domain;

public class Store extends GeneralEntity implements SecondaryEntity<Address> {
    private Long id;
    private String name;
    private Address address;

    public Store (Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Store (String name){
        this.name = name;
    }

    public Store() {

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

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public void setSecondaryEntity(Address address) {
        this.address = address;
    }
}
