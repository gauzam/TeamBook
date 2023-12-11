package com.springboot.TeamBook.dao;

import com.springboot.TeamBook.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
