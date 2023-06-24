package com.user.employee;

import java.util.List;
import java.util.Optional;

import com.user.inn.employee.model.Salary;

public interface ISalaryService {


	public Salary Update(Salary salary) throws Exception;
	
	public String DeleteSalary(Integer id) throws Exception;
	
	public Salary getASingleSalary(Integer id) throws Exception;
	
	public List<Salary> getAllEmployeeSalary();

	public Salary Add(Salary salary);

	
}
