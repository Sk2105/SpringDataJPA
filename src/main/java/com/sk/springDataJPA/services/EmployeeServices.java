package com.sk.springDataJPA.services;


import com.sk.springDataJPA.entities.*;
import com.sk.springDataJPA.models.AddressDTO;
import com.sk.springDataJPA.models.EmpDTO;
import com.sk.springDataJPA.models.EmployeeDTO;
import com.sk.springDataJPA.models.MobileDTO;
import com.sk.springDataJPA.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private MobileRepo mobileRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ProductRepo productRepo;


    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = employeeRepo.findAll(); // List<Employee// >
        List<EmployeeDTO> employeeDTOS = new ArrayList<>(); // List<EmployeeDTO>
        employees.forEach(employee -> employeeDTOS.add(convertToEmployeeDTO(employee)));
        return employeeDTOS;
    }

    public List<com.sk.springDataJPA.entities.Mobile> getMobiles() {
        return mobileRepo.findAll();
    }

    public void saveEmployee(EmpDTO empDTO) {
        Employee employee = new Employee();
        employee.setName(empDTO.name());
        employee.setAge(empDTO.age());
        employee.setEmail(empDTO.email());

        Mobile mobile = new Mobile();
        mobile.setName(empDTO.mobile_name());
        mobile.setPrice(empDTO.mobile_price());
        mobile.setBrand(empDTO.mobile_brand());
        employee.setMobile(mobile);

        mobileRepo.save(mobile);
        employeeRepo.save(employee);


    }

    public void addNewAddress(Long empId, Address address) {
        Employee employee = employeeRepo.findById(empId).get();
        employee.getAddresses().add(address);
        address.setEmployee(employee);
        employeeRepo.save(employee);
    }

    private EmployeeDTO convertToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getName(),
                employee.getEmail(),
                employee.getAge(),
                convertToMobileDTO(employee.getMobile()),
                convertToAddressDtos(employee.getAddresses())
        );

        return employeeDTO;
    }

    private MobileDTO convertToMobileDTO(Mobile mobile) {
        MobileDTO mobileDTO = new MobileDTO(
                mobile.getName(),
                mobile.getPrice(),
                mobile.getBrand()
        );
        return mobileDTO;
    }

    private List<AddressDTO> convertToAddressDtos(List<Address> addresses) {
        List<AddressDTO> addressDtos = new ArrayList<>();
        for (Address address : addresses) {
            addressDtos.add(new AddressDTO(address.getStreet(), address.getCity(), address.getState(), address.getCountry()));
        }
        return addressDtos;
    }


    public void addProduct(ProductDTO product) {
        Product p = new Product();
        p.setName(product.name());
        p.setPrice(product.price());
        Category category = new Category();
        category.setName(product.category());
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(category);
        p.setCategories(categories);
        ArrayList<Product> products = new ArrayList<>();
        products.add(p);
        category.setProducts(products);
        productRepo.save(p);
    }
}
