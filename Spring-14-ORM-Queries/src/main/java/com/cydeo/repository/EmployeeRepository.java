package com.cydeo.repository;


import com.cydeo.entity.Employee;
import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    //Not Equal
    @Query("Select e from Employee e where e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(Integer salary);

    //like/contains/startsWith/endsWith
    @Query("Select e from Employee e where e.firstName LIKE ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    //less than
    @Query("Select e from Employee e where e.salary < ?1 ")
    List<Employee> getEmployeeSalaryLessThan(Integer salary);


    //greater than
    @Query("Select e from Employee e where e.salary > ?1 ")
    List<Employee> getEmployeeSalaryGreaterThan(Integer salary);

    //Before
    @Query("Select e from Employee e where e.hireDate > ?1 ")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    //Between
    @Query("Select e from Employee e where e.salary BETWEEN ?1 AND ?2 ")
    List<Employee> getEmployeeSalaryBetween(Integer salary1, Integer salary2);

    //Null
    @Query("Select e from Employee e where e.email IS NULL")
    List<Employee> getEmployeeEmailIsNull();

    //Not Null
    @Query("Select e from Employee e where e.email IS NOT NULL")
    List<Employee> getEmployeeEmailIsNotNull();

    //Sorting in ascending order
    @Query("Select e from Employee e order by e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    //Sorting in descending order
    @Query("Select e from Employee e order by e.salary desc")
    List<Employee> getEmployeeSalaryOrderDesc();


    //Native SQL Query
    @Query(value = "Select * from employees where salary ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(Integer salary);

    //Named Parameters usage in JPQL and Native SQL query methods
    @Query("Select e from Employee e where e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") Integer salary);


    @Modifying
    @Transactional
    @Query("Update Employee e SET e.email = 'admin@email.com' where e.id=:id")
    void updateEmployeeJPQL(@Param("id") Integer id);


}
