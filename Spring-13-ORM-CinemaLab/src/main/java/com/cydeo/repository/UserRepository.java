package com.cydeo.repository;

import com.cydeo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    Optional<UserAccount> findByEmail(String email);

    //Write a derived query to read a user with an username?
    Optional<UserAccount> findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<UserAccount> findAllByAccountDetails_NameContaining(String name);


    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<UserAccount> findAllByAccountDetails_NameContainingIgnoreCase(String name);


    //Write a derived query to list all users with an age greater than a specified age?
    List<UserAccount> findAllByAccountDetails_AgeGreaterThan(int age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("select user from UserAccount user where LOWER(user.email) = LOWER(?1) ")
    Optional<UserAccount> getUserByEmail(String email);


    //Write a JPQL query that returns a user read by username?
    @Query("select user from UserAccount user where lower(user.username) = lower(?1) ")
    Optional<UserAccount> getUserByUsername(String username);

    //Write a JPQL query that returns all users?
    List<UserAccount> findAll();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "select * from user_account ua join account_details ad " +
            "on ua.account_details_id= ad.id where ad.name ilike concat('%', ?1, '%')",nativeQuery = true)
    List<UserAccount> getAllUsersByNameContains(String name);


    //Write a native query that returns all users?
    @Query(value = "select * from user_account",nativeQuery = true)
    List<UserAccount> getAllUsers();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "select * from user_account ua join account_details ad " +
            "on ua.account_details_id = ad.id where ad.age between ?1 and ?2",nativeQuery = true)
    List<UserAccount> getAllUsersByAgeOfRange(Integer startAge, Integer endAge);

    //Write a native query to read a user by email?
    @Query(value = "select * from user_account where email = ?1", nativeQuery = true)
    Optional<UserAccount> retrieveUserByEmail(String email);

}
