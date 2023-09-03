package com.cydeo.bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container =
                new AnnotationConfigApplicationContext(ConfigEmployee.class,ConfigObjects.class);

        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        ft.createAccount();

        container.getBean(PartTimeEmployee.class).createAccount();

        System.out.println(container.getBean("getCydeoAppObject",String.class));

        System.out.println(container.getBean( "getCorePracticeObject",String.class));

    }

}
