package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {

    //Display all regions in Canada

    /**
     * It's like saying Select * from regions where country='Canada';
     */
    List<Region> findRegionByCountry(String country);

    //Display all regions in Canada, without duplicates
    //Select * from regions where ....
    List<Region> findDistinctByCountry(String country);


    //Display all regions with country name includes 'United'
    List<Region> findRegionByCountryContainingIgnoreCase(String country);

    //Display all regions with country name included 'United' in asc order
    List<Region> findRegionByCountryContainingOrderByCountry(String country);


    //Display top 3 regions in Canada
    List<Region> findTop2ByCountry(String country);


}
