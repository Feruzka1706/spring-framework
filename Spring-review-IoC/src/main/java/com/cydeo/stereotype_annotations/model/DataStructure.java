package com.cydeo.stereotype_annotations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
//@AllArgsConstructor
//@Builder
@Data
public class DataStructure {

    @NonNull
    ExtraHours extraHours;

    public void getTotalHours(){
        System.out.println("Total hour for course : "+ (100 +extraHours.getHours()));
    }
}
