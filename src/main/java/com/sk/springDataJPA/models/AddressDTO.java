package com.sk.springDataJPA.models;

public record AddressDTO(
    String street,
    String city,
    String state,
    String country
) {
}
