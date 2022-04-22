package com.project.employeedatabase.dao;

import com.project.employeedatabase.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // We are use JpaRepository for access to CRUD (Create, Read, Update, Delete) operations
    // like findAll, findById...
    // We have this EmployeeRepository to specific the entity we are working with and we can add customs
    // methods
}
