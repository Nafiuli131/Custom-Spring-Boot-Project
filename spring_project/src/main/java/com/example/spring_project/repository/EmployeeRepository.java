package com.example.spring_project.repository;

import com.example.spring_project.entity.Employee;
import com.example.spring_project.generics.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends GenericRepository<Employee> {
}
