package com.sk.springDataJPA.repository;

import com.sk.springDataJPA.entities.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepo extends JpaRepository<Mobile, Long> {
}
