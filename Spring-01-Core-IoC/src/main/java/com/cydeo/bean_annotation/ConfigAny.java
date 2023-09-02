package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAny {

    @Bean
    public String str(){
        return "Develoer";
    }

    @Bean
    Integer number(){
        return 100;
    }
}

