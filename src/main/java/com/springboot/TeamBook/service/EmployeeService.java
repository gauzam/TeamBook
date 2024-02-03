package com.springboot.TeamBook.service;

import com.springboot.TeamBook.dto.EmployeeDTO;
import com.springboot.TeamBook.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    EmployeeDTO save(EmployeeDTO employeeDTO);

    void deleteById(int theId);

}
