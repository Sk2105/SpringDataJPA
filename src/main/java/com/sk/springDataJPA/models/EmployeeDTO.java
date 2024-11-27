package com.sk.springDataJPA.models;

import java.util.List;

public record EmployeeDTO(
    String name,
    String email,
    Integer age,
    MobileDTO mobile,
    List<AddressDTO> address
) {
}
