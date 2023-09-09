package com.cydeo.service;

import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

@Component
public class OvertimeSalaryService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    @Qualifier("OvertimeHours")
    HoursRepository hoursRepository;

    /**
     public OvertimeSalaryService(EmployeeRepository employeeRepository, @Qualifier("OvertimeHours") HoursRepository hoursRepository) {
     this.employeeRepository = employeeRepository;
     this.hoursRepository = hoursRepository;
     }
     */

    public void calculateRegularSalary(){
        //HourlyRate * Overtime Hours
        System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());
    }
}
