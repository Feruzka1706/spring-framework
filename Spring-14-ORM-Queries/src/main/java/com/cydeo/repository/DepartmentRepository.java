package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

    //Display all departments in the furniture department
    List<Department> findDepartmentByDepartment(String department);

    //Display all departments in the Health Division
    List<Department> findByDivisionEquals(String division);

    //Department top 3 departments with division name includes 'Hea' without duplicates;
    List<Department> findDistinctTop3ByDivisionContainingIgnoreCase(String division);


    @Query("select d from Department d where d.division IN ?1")
    List<Department>  getDepartmentDivision(List<String> division);

    List<Department> retrieveDepartmentByDivision(String division);

    @Query(value = "SELECT * FROM departments WHERE division ILIKE concat('%',?1,'%') ",nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);
    //ectroc

}
