package com.project.employeedatabase.controller;

import com.project.employeedatabase.entity.Employee;
import com.project.employeedatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class EmployeeController {

    //access employee data
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService){
        this.employeeService =theEmployeeService;
    }

    // add mapping for GET"/employees"
    @GetMapping("/employees")
    public List<Employee>listEmployees(){
        //get the employees from the database
        List<Employee> theEmployees = employeeService.findAll();
        return theEmployees;
    }

    // add mapping for GET "/employees/{employeeId}"
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        //get the employee from the database
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        return theEmployee;
    }

    // add mapping for POST "/employees/{employeeId} add new employee"
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //just in case they pass an id in the JSON ... set id to 0
        //this is to force new item ... instead of update
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    // add mapping for PUT "/employees" updating existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        //update the employee
        employeeService.save(theEmployee);
        return theEmployee;
    }

    // add mapping for DELETE "/employees" updating existing employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        //get the employee to be deleted
        Employee tempEmployee = employeeService.findById(employeeId);
        //throw exeception if null
        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee with ID: "+employeeId+" has been deleted";
    }
}
