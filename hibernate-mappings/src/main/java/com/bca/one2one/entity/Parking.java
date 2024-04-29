package com.bca.one2one.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parking_table")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String loc;
    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public Parking(String loc, Employee employee) {
        this.loc = loc;
        this.employee = employee;
    }
}
