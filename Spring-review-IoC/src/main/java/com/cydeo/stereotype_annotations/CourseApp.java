package com.cydeo.stereotype_annotations;

import com.cydeo.stereotype_annotations.config.ConfigCourse;
import com.cydeo.stereotype_annotations.model.DataStructure;
import com.cydeo.stereotype_annotations.model.Microservices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CourseApp {
    public static void main(String[] args) {

        ApplicationContext container =
                new AnnotationConfigApplicationContext(ConfigCourse.class);

        container.getBean(DataStructure.class).getTotalHours();

        container.getBean(Microservices.class).getTotalHours();
    }


}
