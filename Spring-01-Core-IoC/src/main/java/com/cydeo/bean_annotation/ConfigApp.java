package com.cydeo.bean_annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigApp {

    @Bean
   FullTimeMentor fullTimeMentor(){
       return new FullTimeMentor();
   }

   @Bean()
   @Primary
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }

    @Bean("p2")
    PartTimeMentor partTimeMentor2(){
        return new PartTimeMentor();

    }
}
