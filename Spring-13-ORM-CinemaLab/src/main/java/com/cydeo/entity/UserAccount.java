package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_account")
public class UserAccount extends BaseEntity{

    private String email;
    private String password;
    private String username;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_details_id")
    private AccountDetails userAccount;


}
