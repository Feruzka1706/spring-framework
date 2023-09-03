package com.cydeo.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigObjects {


    @Bean
    public String getCydeoAppObject(){
          return "Welcome to CydeoApp";
    }

    @Bean
    public String getCorePracticeObject(){
        return "Core Practice";
    }


}
