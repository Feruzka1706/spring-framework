package com.cydeo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_owner")
    private String owner;
    @Column(name = "account_balance")
    private BigDecimal balance;
    private BigDecimal interestRate;
}
