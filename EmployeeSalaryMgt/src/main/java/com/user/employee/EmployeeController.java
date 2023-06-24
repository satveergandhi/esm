package com.user.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.inn.employee.model.Bonus;
import com.user.inn.employee.model.EmployeeDetails;
import com.user.inn.employee.model.Salary;
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService service;
	
	 @PostMapping("/employee")
	    public EmployeeDetails create(@RequestBody EmployeeDetails employee){
	        return service.create(employee);
	    }
	 
	 @PutMapping("/employee")
	    public EmployeeDetails update(@RequestBody EmployeeDetails employee){
	        return service.update(employee, 0);
	    }

	
	@GetMapping("/getByUserName/{name}")
	public EmployeeDetails getByUserName(@RequestParam String firstName)
	{
		return this.service.findEmployee(firstName);
	}
	
	 @GetMapping("/getById/{id}")
	  public EmployeeDetails getById(@RequestParam int id) {
		 return this.service.findEmployeeById(id);
	  }
	
	@GetMapping("/getAllEmployees")
	public List<EmployeeDetails> getAll()
	{
		return this.service.findAll();
	}
}
