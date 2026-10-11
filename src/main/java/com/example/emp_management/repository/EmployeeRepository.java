package com.example.emp_management.repository;

import com.example.emp_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; // for list this package is imp[

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName,
            String lastName
    );
}



/*

JpaRepository already gives us:

Create
Get all
Get by ID
Update
Delete
Pagination
Sorting

*/
