package com.sk.springDataJPA.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;

    @OneToOne
    private Mobile mobile;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Address> addresses; // List<Address>
}
