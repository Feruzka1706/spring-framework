package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Data

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_make")
    private String make;
    @Column(name = "car_model")
    private String model;


    //we need constructor without primary key, cause postrges is handling primary key
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
}
