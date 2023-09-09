package com.cydeo.repository;

import org.springframework.stereotype.Component;

@Component("RegularHours")
public class RegularHours implements HoursRepository{
    @Override
    public int getHours() {
        return 40;
    }
}
