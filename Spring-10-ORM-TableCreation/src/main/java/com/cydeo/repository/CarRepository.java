package com.cydeo.repository;

import com.cydeo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//With Spring higher version not necessary putting @Repository annotation since it's already used
//inside JpaRepository
public interface CarRepository extends JpaRepository<Car,Long> {

    //we can put here custom methods, most of the cases SQL clause methods
    //if JPA repository has existing implementation methods I can use it as well

}
