package com.example.spring_project.controller;

import com.example.spring_project.entity.Employee;
import com.example.spring_project.generics.GenericController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends GenericController<Employee> {

    @GetMapping("/hello")
    public ResponseEntity<String> helloBody(){
        return new ResponseEntity<>("Hello Spring Boot", HttpStatus.OK);
    }
}
