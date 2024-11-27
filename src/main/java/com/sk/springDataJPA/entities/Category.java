package com.sk.springDataJPA.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    private List<Product> products; // List<Product>
}
