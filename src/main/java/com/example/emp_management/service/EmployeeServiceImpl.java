package com.example.emp_management.service;

import com.example.emp_management.dto.EmployeeRequest;
import com.example.emp_management.entity.Employee;


import com.example.emp_management.repository.EmployeeRepository;
import com.example.emp_management.exception.EmployeeNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee createEmployee(EmployeeRequest request) {
		Employee employee = new Employee();

		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setEmail(request.getEmail());
		employee.setAge(request.getAge());
		employee.setSalary(request.getSalary());
		employee.setActive(request.getActive());
		employee.setJoiningDate(request.getJoiningDate());
		employee.setGender(request.getGender());
		employee.setCreatedAt(LocalDateTime.now());

		return employeeRepository.save(employee);

	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id)
		        .orElseThrow(() ->
		                new EmployeeNotFoundException(
		                        "Employee not found with id: " + id));
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Long id, EmployeeRequest request) {
		// TODO Auto-generated method stub
		Employee employee = getEmployeeById(id);

		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setEmail(request.getEmail());
		employee.setAge(request.getAge());
		employee.setSalary(request.getSalary());
		employee.setActive(request.getActive());
		employee.setJoiningDate(request.getJoiningDate());
		employee.setGender(request.getGender());

		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee employee = getEmployeeById(id);

		employeeRepository.delete(employee);
	}

	@Override
	public List<Employee> searchEmployees(String keyword) {
		// TODO Auto-generated method stub
		return employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(keyword, keyword);
	}

}
