package com.springboot.TeamBook.service;

import com.springboot.TeamBook.dao.EmployeeRepository;
import com.springboot.TeamBook.dto.EmployeeDTO;
import com.springboot.TeamBook.entity.Employee;
import com.springboot.TeamBook.exceptions.ResourceNotFoundException;
import com.springboot.TeamBook.mapper.EmployeeMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    //injecting employeeRepository dependency
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDTO findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isEmpty()){
            //employee not found
            throw new ResourceNotFoundException("Did not find employee id - " + theId);

        }
        else{
            theEmployee = result.get();
        }

        return EmployeeMapper.mapToEmployeeDTO(theEmployee);
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {

        Employee theEmployee = EmployeeMapper.mapToEmployee(employeeDTO);

        Employee savedEmployee = employeeRepository.save(theEmployee);

        EmployeeDTO savedEmployeeDTO = EmployeeMapper.mapToEmployeeDTO(savedEmployee);

        return savedEmployeeDTO;
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
