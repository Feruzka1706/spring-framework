package com.cydeo.controller;

import com.cydeo.client.EmployeeClient;
import com.cydeo.client.UserClient;
import com.cydeo.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Consume_FeignClient {

  private final   UserClient userClient;
  private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient=employeeClient;
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseWrapper> getAllUsers(){

        return ResponseEntity.ok(new ResponseWrapper("User List retrieved",
                userClient.getUsers()));
    }

    @GetMapping("/employee")
    public ResponseEntity<ResponseWrapper> getEmployeeWithSize10Limit(){
        return ResponseEntity.ok(new ResponseWrapper("Successfully retrieved ",
                employeeClient.getEmployeeLimitWith10("6298ebfecd0551211fce37a6")));
    }

}
