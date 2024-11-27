package com.sk.springDataJPA.repository;

import com.sk.springDataJPA.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
