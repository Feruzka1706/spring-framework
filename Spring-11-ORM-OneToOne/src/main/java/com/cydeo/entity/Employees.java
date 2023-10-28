package com.cydeo.entity;

import com.cydeo.enums.Gender;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employees extends BaseEntity {


    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE", name = "hire_date")
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int salary;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Departments department;

    @OneToOne(cascade = CascadeType.ALL)
    //@OneToOne(cascade = {CascadeType.ALL,CascadeType.PERSIST})
    @JoinColumn(name = "region_id")
    private Region regionId;
    public Employees(String firstName, String lastName,
                     String email, LocalDate hireDate,
                     int salary,Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
        this.gender = gender;
    }
}
