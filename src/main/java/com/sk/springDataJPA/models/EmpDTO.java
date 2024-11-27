package com.sk.springDataJPA.models;

public record EmpDTO(
    String name,
    String email,
    Integer age,
    String mobile_name,
    double mobile_price,
    String mobile_brand
) {
}
