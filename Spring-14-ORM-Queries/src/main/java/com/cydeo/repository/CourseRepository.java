package com.cydeo.repository;

import com.cydeo.entity.Course;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;


public interface CourseRepository extends JpaRepository<Course,Long> {


    //find all courses by category
    //1st Derived query way
    List<Course> findCourseByCategory(String category);

    //Find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String name);

    //Check if a course with the provided name exists, return true if course exists, false otherwise
    boolean existsByName(String name);

    //returns the count of courses for the provided category
    int countByCategory(String category);

    //find all courses that starts with the provided course name
    List<Course> findByNameStartsWith(String name);

    /**
     * If we are using derived queries, try to not make complicated
     * it should be readable, if more conditions then better to implement JPQL queries
     */

    //Find all courses by category and return a stream
    Stream<Course> streamByCategory(String category);

    @Query("select c from Course c where c.category=:category AND c.rating > :rating")
    List<Course>findAllByCategoryAndRatingGreaterThan(@Param("category") String category,
                                                      @Param("rating") Integer rating );



}
