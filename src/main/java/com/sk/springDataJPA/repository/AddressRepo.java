package com.sk.springDataJPA.repository;

import com.sk.springDataJPA.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
