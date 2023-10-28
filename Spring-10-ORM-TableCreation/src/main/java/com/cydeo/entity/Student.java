package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //if field names are camelCase, spring will generate by default column names
    //as following format: first_name
    //or we can specify column names explicitly
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    /**
     * If we have a field and I don't want to persiste the field/data to the object
     * I can use @Transient
     */
    @Transient
    private String city;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateTime;

    //If we have enum,and we didn't modify it, by default it will be treated as intg
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Student(Long id, String firstName, String lastName,
                   String email, String city, LocalDate birthDate,
                   LocalTime birthTime, LocalDate birthDateTime,
                   Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.birthDate = birthDate;
        this.birthTime = birthTime;
        this.birthDateTime = birthDateTime;
        this.gender = gender;
    }
}
