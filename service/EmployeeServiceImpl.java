package com.project.employeedatabase.service;

import com.project.employeedatabase.dao.EmployeeRepository;
import com.project.employeedatabase.entity.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee=result.get();
        }else{
            throw new RuntimeException("Did not find employee id - "+theId);
        }
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);

    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
