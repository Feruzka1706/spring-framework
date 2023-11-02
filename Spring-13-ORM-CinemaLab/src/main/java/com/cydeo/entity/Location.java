package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Location extends BaseEntity{

    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String postalCode;
    private String country;
    private String state;
    private String city;
    private String address;


    //we don't need Constructor because we are using Data.sql to load data to use
    //Constructor need when we are getting data from user and assigning to object
    public Location(String name, BigDecimal latitude,
                    BigDecimal longitude, String postalCode,
                    String country, String state,
                    String city, String address) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
    }

}
