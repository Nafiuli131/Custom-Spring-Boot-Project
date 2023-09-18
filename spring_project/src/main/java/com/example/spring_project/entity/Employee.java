package com.example.spring_project.entity;

import com.example.spring_project.generics.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee extends BaseEntity {
    private Double salary;
    private Integer age;
    private String name;
}
