package com.cydeo.data;

import com.cydeo.entity.Departments;
import com.cydeo.entity.Employees;
import com.cydeo.entity.Region;
import com.cydeo.enums.Gender;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {


    EmployeeRepository employeeRepository;
   // DepartmentRepository departmentRepository;

    public DataGenerator( EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        Employees e1 = new Employees("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006,04,20),154864, Gender.FEMALE);
        Employees e2 = new Employees("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009,01,26),56752, Gender.FEMALE);
        Employees e3 = new Employees("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010,05,17),95313, Gender.FEMALE);
        Employees e4 = new Employees("Avrom", "Rowantree", null, LocalDate.of(2014,03,02) ,119764,Gender.MALE);
        Employees e5 = new Employees("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003,01,14), 55307,Gender.MALE);

        Departments d1 = new Departments("Sports","Outdoors");
        Departments d2 = new Departments("Tools","Hardware");
        Departments d3 = new Departments("Clothing","Home");
        Departments d4 = new Departments("Phones & Tablets","Electronics");
        Departments d5 = new Departments("Computers","Electronics");

        Region r1 = new Region("Southwest","United States");
        Region r2 = new Region("Central","United States");
        Region r3 = new Region("Northwest","United States");
        Region r4 = new Region("Quebec'","Canada");
        Region r5 = new Region("Central","Asia");

        e1.setDepartment(d1);
        e2.setDepartment(d2);
        e3.setDepartment(d3);
        e4.setDepartment(d4);
        e5.setDepartment(d5);

        e1.setRegionId(r1);
        e2.setRegionId(r2);
        e3.setRegionId(r3);
        e4.setRegionId(r4);
        e5.setRegionId(r5);

        List<Employees> employees = Arrays.asList(e1,e2,e3,e4,e5);
        List<Departments> departments = Arrays.asList(d1,d2,d3,d4,d5);
        //save these objects to db
        employeeRepository.saveAll(employees);
        //departmentRepository.saveAll(departments);
    }


}
