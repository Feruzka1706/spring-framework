package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "merchants")
@Data
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String merchantCode;
    private BigDecimal transactionFee;
    private BigDecimal commissionRate;
    private Integer payoutDelayCount;


    @OneToMany(mappedBy = "merchantId") //in the table one merchant can do multiple payments
    //Rule is one-to-many relationship, ownership belongs to Many side
    private List<Payment> paymentList;

    public Merchant(String name, String merchantCode,
                    BigDecimal transactionFee,
                    BigDecimal commissionRate,
                    Integer payoutDelayCount) {
        this.name = name;
        this.merchantCode = merchantCode;
        this.transactionFee = transactionFee;
        this.commissionRate = commissionRate;
        this.payoutDelayCount = payoutDelayCount;
    }
}
