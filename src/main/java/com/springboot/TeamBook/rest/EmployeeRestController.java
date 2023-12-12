package com.springboot.TeamBook.rest;

import com.springboot.TeamBook.dao.EmployeeDAO;
import com.springboot.TeamBook.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    //quick and dirty: inject employee DAO (using constructor injection)
    //will add service layer later on

    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    //expose '/employees' endpoint and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }


}
