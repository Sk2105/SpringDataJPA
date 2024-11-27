package com.sk.springDataJPA.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data(
        staticConstructor = "of"
)
@NoArgsConstructor
@AllArgsConstructor
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String brand;



}
