package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Data
public class Departments extends BaseEntity{


    private String department;
    private String division;


    @OneToOne(mappedBy = "department")
    private Employees employee;

    public Departments(String department, String division) {
        this.department = department;
        this.division = division;
    }

}
