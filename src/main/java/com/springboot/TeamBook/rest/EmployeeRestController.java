package com.springboot.TeamBook.rest;

import com.springboot.TeamBook.dto.EmployeeDTO;
import com.springboot.TeamBook.entity.Employee;
import com.springboot.TeamBook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //adding employeeService dependency
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    //expose '/employees' endpoint and return a list of employees
    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        return theEmployee;
    }

    // add mapping for POST /employees
    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){

        //just in case they pass an id in json... set it to 0
        //this is to force the insert of the new item... instead of update

        //theEmployee.setId(0);

        EmployeeDTO savedEmployeeDTO = employeeService.save(employeeDTO);

        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);

    }

    //add mapping for PUT /employees - update an existing employee
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete an employee
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        //throw exception if null

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee with id: " + employeeId;
    }



}
