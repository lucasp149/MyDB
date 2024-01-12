package com.solvd.storeDataBase.domain;

import com.solvd.storeDataBase.domain.interfaces.SecondaryEntity;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city")
public class City extends GeneralEntity implements SecondaryEntity<Zone> {
    @XmlAttribute(name="id")
    private Long id;
    private String name;

    private Zone zone;


    public City(){}
    public City(String name){
        this.name = name;
    }

    public City (Long id,String name){
        this.id = id;
        this.name = name;
    }

    public City (String name, Zone zone){
        this.name = name;
        this.zone = zone;
    }
    public City (Long id,String name, Zone zone){
        this.id = id;
        this.name = name;
        this.zone = zone;
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

    public Zone getZone() {
        return this.zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zone=" + this.zone +
                '}';
    }

    @Override
    public void setSecondaryEntity(Zone zone) {
        this.zone = zone;
    }
}
