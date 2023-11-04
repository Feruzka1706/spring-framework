package com.cydeo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

    @Id
    /**
     * We are not using in this project
     * @GeneratedValue(strategy = GenerationType.IDENTITY)
     * because we are entering to our entity tables ready data
     * from data.sql file and there is already for id numbers are given
     * for each column. We are just telling Spring that Long numbers
     * which we have in the data.sql, mark them as id for the entity table
     */
    private Long id;

}
