package com.sk.springDataJPA.repository;

public record ProductDTO(
        String name,
        double price,
        String category
) {
}
