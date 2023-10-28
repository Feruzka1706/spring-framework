package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
@NoArgsConstructor
@Data
public class Region extends BaseEntity{

    @Column(name = "region")
    private String region;
    @Column(name = "country")
    private String country;

    @OneToOne(mappedBy = "regionId")
    private Employees employee;

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
