package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    //fetch = FetchType.LAZY requested information will be loaded only when it's requested
    //if we don't explicitly show the fetching type, byt default it will be EAGER which might cause performance issue of the application

    private List<Payment> paymentList;


    public Customer(String userName,
                    String firstName,
                    String lastName,
                    String email,
                    String address) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }
}
