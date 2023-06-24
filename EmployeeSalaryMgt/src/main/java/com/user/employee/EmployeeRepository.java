package com.user.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.user.inn.employee.model.Bonus;
import com.user.inn.employee.model.EmployeeDetails;
import com.user.inn.employee.model.Salary;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer>{


	@Query(value = "SELECT emp FROM EmployeeDetails emp WHERE emp.employeeId= ?1 ")
	EmployeeDetails findempById(int id) ;

	@Query(value = "SELECT emp FROM EmployeeDetails emp WHERE emp.firstName = ?1 ")
	EmployeeDetails findempByname(String firstname);

	EmployeeDetails save(EmployeeDetails employee);
	  
}