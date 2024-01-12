package com.solvd.storeDataBase.domain;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="passport")
public class Passport extends GeneralEntity {
    @XmlAttribute(name = "id")
    private Long id;
    private String number;

    public Passport() {
    }

    public Passport (String number) {
        setNumber(number);
    }
    public Passport (Long id, String number) {
        setId(id);
        setNumber(number);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName(){
        return getNumber();
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
