package com.user.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.inn.employee.model.Bonus;
import com.user.inn.employee.model.EmployeeDetails;
import com.user.inn.employee.model.Salary;
@Service
public class EmployeeService {
	
	private EmployeeDetails employeeDetails;
	
	@Autowired
	private EmployeeRepository employeeRepository;

		@Autowired
		public EmployeeService(EmployeeRepository employeeRepository) {
			this.employeeRepository = employeeRepository;
		} 
		
	    public EmployeeDetails create(EmployeeDetails employee) {
	        return employeeRepository.save(employee);
	    }
	    
	    public EmployeeDetails update(EmployeeDetails employee,int employee_id) {
	        return employee;
	    }
		
		public EmployeeDetails findEmployee(String firstName) {
			EmployeeDetails empname = employeeRepository.findempByname(firstName);
			return empname;
		}

		public List<EmployeeDetails> findAll() {
			return employeeRepository.findAll();
		}

		public EmployeeDetails findEmployeeById(int id) {
			EmployeeDetails emp = employeeRepository.findempById(id);
		   return emp;
		}

		
}
