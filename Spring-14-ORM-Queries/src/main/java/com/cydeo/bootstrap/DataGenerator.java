package com.cydeo.bootstrap;


import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    @Override
    public void run(String... args) throws Exception {

        System.out.println("------------------REGION START--------------------------");
        //accessing method that I built within Region repository class?
        //By doing dependency injection
        System.out.println("findRegionByCountry: "+regionRepository.findRegionByCountry("Canada"));
        System.out.println("findDistinctByCountry: "+regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findRegionByCountryContainingIgnoreCase: "+regionRepository.findRegionByCountryContainingIgnoreCase("United"));
        System.out.println("findRegionByCountryContainingOrderByCountry: "+regionRepository.findRegionByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry: " +regionRepository.findTop2ByCountry("United States"));
        System.out.println("------------------REGION END--------------------------");


        System.out.println("------------------Department START--------------------------");

        System.out.println("findDepartmentByDepartment: "+departmentRepository.findDepartmentByDepartment("Toys"));
        System.out.println("findByDivisionEquals: "+departmentRepository.findByDivisionEquals("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionContainingIgnoreCase: "+departmentRepository.findDistinctTop3ByDivisionContainingIgnoreCase("ent"));
        System.out.println("------------------Department END--------------------------");


        System.out.println("------------------Employee START--------------------------");

        System.out.println("findByEmail: "+employeeRepository.findByEmail("myakovlivf@ucsd.edu"));
        //System.out.println("findEmployeeByFirstNameAndLastNameOrEmail: "+
              //  employeeRepository.findEmployeeByFirstNameAndLastNameOrEmail("Lucy","",""));
        System.out.println("getEmployeeDetails(): " + employeeRepository.getEmployeeDetails());
        System.out.println("getEmployeeSalary: "+employeeRepository.getEmployeeSalary());
        System.out.println("------------------Employee END--------------------------");

    }
}
