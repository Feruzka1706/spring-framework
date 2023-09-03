package com.cydeo.stereotype_annotations.model;
import org.springframework.stereotype.Component;

@Component
public class Microservices {

    public void getTotalHours(){
        System.out.println("Total hour for course : "+80);
    }
}
