package com.cydeo.repository;

import org.springframework.stereotype.Component;

@Component("OvertimeHours")
public class OvertimeHours implements HoursRepository{

    @Override
    public int getHours() {
        return 15;
    }
}
