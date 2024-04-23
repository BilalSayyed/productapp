package com.bca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(name = "emp_name",nullable = false,length = 100)
private String name;
    @Column(name = "emp_salary",nullable = false)
private int salary;
    @Column(name = "emp_dept",nullable = false,length = 100)
private String dept;

    public Employee(String name, int salary, String dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }
}
