package com.sk.springDataJPA.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String country;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
}
