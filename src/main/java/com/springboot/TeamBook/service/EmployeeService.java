package com.springboot.TeamBook.service;

import com.springboot.TeamBook.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
