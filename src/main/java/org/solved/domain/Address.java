package org.solved.domain;

public class Address extends GeneralEntity implements SecondaryEntity<City> {
    private Long id;
    private String streetName;
    private Integer number;
    private City city;

    public Address(String streetName, Integer number) {
        this.streetName = streetName;
        this.number = number;
    }

    public Address(Long id, String streetName, Integer number) {
        this.id = id;
        this.streetName = streetName;
        this.number = number;
    }

    public Address(String streetName, Integer number, City city) {
        this.streetName = streetName;
        this.number = number;
        this.city = city;
    }

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", number=" + number +
                ", city=" + city +
                '}';
    }

    @Override
    public void setSecondaryEntity(City city) {
        this.city = city;
    }

    public String getName(){
        return streetName+" "+Integer.toString(number);
    }
}
