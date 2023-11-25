package com.cydeo.repository;

import com.cydeo.entity.AccountDetails;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<AccountDetails> findByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<AccountDetails> findByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<AccountDetails> findByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<AccountDetails> findByAgeBetween(Integer startAge, Integer endAge);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<AccountDetails> findByAddressStartsWith(String keyword);

    //Write a derived query to sort the list of accounts with age
    List<AccountDetails> findByOrderByAgeAsc();



    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("select account from AccountDetails account")
    List<AccountDetails>  getAllAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("select a from AccountDetails a where a.role = 'ADMIN'")
    List<AccountDetails> getAllAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("select a from AccountDetails a order by a.age")
    List<AccountDetails> getAllAccountsSortedByAge(Integer age);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age < ?1", nativeQuery = true)
    List<AccountDetails> getAllAccountsByAgeLowerThan(Integer age);


    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "select * from account_details where " +
            " name ILIKE %?1% or address ILIKE concat('%',?1,'%') " +
            " or country ILIKE concat('%',?1,'%') " +
            " or state ILIKE %?1% or city LIKE %?1%", nativeQuery = true)
    List<AccountDetails> getAllAccountsContainingValue(String value);


    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age < :age", nativeQuery = true)
    List<AccountDetails> getAllAccountsByAgeLowerThanParam(@Param("age") Integer age);

}
