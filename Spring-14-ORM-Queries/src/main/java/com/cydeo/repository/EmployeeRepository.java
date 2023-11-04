package com.cydeo.repository;


import com.cydeo.entity.Employee;
import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Display all employees with email address ' '
    List<Employee> findByEmail(String email);

    //Display all employees with first name ' ' and last name ' ',
    // also show all employees with an email address
    List<Employee> findEmployeeByFirstNameAndLastNameOrEmail(
            String firstName, String lastName, String email);

    //Display all employees that first name is not ' '
    List<Employee> findEmployeeByFirstNameIsNot(String firstName);

    //Display all employees where last name starts with ' '
    List<Employee> findEmployeeByLastNameStartsWith(String lastName);


    //Display all employees with salaries higher than ' '
    List<Employee> findEmployeeBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less than ' '
    List<Employee> findEmployeeBySalaryLessThan(Integer salary);

    //Display employee who has max salary
    Employee findTopByOrderBySalaryDesc();

    //Display all employees that has been hired between ' ' and ' '
    List<Employee> findEmployeeByHireDateBetween(LocalDate startDate, LocalDate endDate );

    //Display all employees where salaries greater and equal to ' ' in order by desc
    List<Employee> findEmployeeBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that are making less than ' '
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address;
    List<Employee> findByEmailIsNull();


    //JPQL practice
    @Query("Select e from Employee e where e.email = 'amcnee1@google.es'")
    Employee getEmployeeDetails();

    //Get salary of specific employee where email is = something
    @Query("Select e.salary from Employee e where e.email = 'sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    //Parametrizing JPQL queries
    @Query("Select e from Employee e where e.email = ?1")
    Optional<Employee> getEmployeeDetails(String email);
    //If there is no matching record it will throw Null pointer, to handle we are using Optional
    ///and if record doesn't exist it will return empty optional object

    @Query("Select e from Employee e where e.email = ?1 AND e.salary= ?2")
    Optional<Employee> getEmployeeDetailsByEmailAndSalary(String email, Integer salary);

}
