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
    public ResponseEntity<List<EmployeeDTO>> findAll(){

        List<EmployeeDTO> employeeDTOs = employeeService.findAll();

        return ResponseEntity.ok(employeeDTOs);
    }

    // add mapping for GET /{employeeId}
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int employeeId){

        EmployeeDTO employeeDTO = employeeService.findById(employeeId);

        //creating and returning response entity with employeeDTO as response body
        //and HTTP status code of 200 OK
        return ResponseEntity.ok(employeeDTO);
    }

    // add mapping for POST /employees
    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){

        //just in case they pass an id in json... set it to 0
        //this is to force the insert of the new item... instead of update

        //theEmployee.setId(0);

        EmployeeDTO savedEmployeeDTO = employeeService.save(employeeDTO);

        //creating and returning response entity with savedEmployeeDTO as response body
        //and 201 as HTTP status code
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
