package com.sk.springDataJPA.controller;


import com.sk.springDataJPA.entities.Address;
import com.sk.springDataJPA.entities.Employee;
import com.sk.springDataJPA.entities.Mobile;
import com.sk.springDataJPA.models.EmpDTO;
import com.sk.springDataJPA.models.EmployeeDTO;
import com.sk.springDataJPA.repository.ProductDTO;
import com.sk.springDataJPA.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping
    public List<EmployeeDTO> getEmployee() {
        return employeeServices.getEmployees();
    }

    @PostMapping
    public void addEmployee(@RequestBody EmpDTO employee) {
        employeeServices.saveEmployee(employee);
    }

    @GetMapping("/mobile")
    public List<Mobile> getMobile() {
        return employeeServices.getMobiles();
    }


    @PostMapping("/address/{empId}")
    public void addAddress(@RequestBody Address address, @PathVariable Long empId) {
        employeeServices.addNewAddress(empId, address);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody ProductDTO product) {
        employeeServices.addProduct(product);
    }
}
