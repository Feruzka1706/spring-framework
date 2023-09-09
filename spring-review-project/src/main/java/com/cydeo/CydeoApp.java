package com.cydeo;

import com.cydeo.config.ConfigHours;
import com.cydeo.service.OvertimeSalaryService;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class CydeoApp {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigHours.class);

        SalaryService salaryService = container.getBean(SalaryService.class);

        salaryService.calculateRegularSalary();

        OvertimeSalaryService overtimeSalaryService = container.getBean(OvertimeSalaryService.class);
        overtimeSalaryService.calculateRegularSalary();
    }

}

