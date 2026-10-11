package com.example.emp_management.service;

import com.example.emp_management.dto.EmployeeRequest;
import com.example.emp_management.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(EmployeeRequest request);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Long id, EmployeeRequest request);

    void deleteEmployee(Long id);

    List<Employee> searchEmployees(String keyword);
}

 