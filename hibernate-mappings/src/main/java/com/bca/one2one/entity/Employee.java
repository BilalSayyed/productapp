package com.bca.one2one.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    private Parking parking;

    public Employee(String name, Parking parking) {
        this.name = name;
        this.parking = parking;
    }
}
