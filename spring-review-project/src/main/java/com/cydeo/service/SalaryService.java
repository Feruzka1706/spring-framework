package com.cydeo.service;

import lombok.AllArgsConstructor;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class SalaryService {

    /*
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    @Qualifier("RegularHours")
    HoursRepository hoursRepository;
     */

    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;


    public SalaryService(EmployeeRepository employeeRepository, @Qualifier("RegularHours") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateRegularSalary(){
        //HourlyRate * Regular Hours
        System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());
    }

}
