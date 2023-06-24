package com.user.employee;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.employee.controller.ISalaryConroller;
import com.user.inn.employee.model.Salary;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("Salary")
@Slf4j
public class SalaryController implements ISalaryConroller {

	@Autowired
	ISalaryService salaryService;

	@Override
	public Salary Add(Salary salary) {
		return salaryService.Add(salary);
	}

	@Override
	public Salary Update(Salary salary) throws Exception {
		try {
			return salaryService.Update(salary);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String DeleteSalary(Integer id) throws Exception {
		return salaryService.DeleteSalary(id);
	}

	@Override
	public Salary getASingleSalary(Integer id) throws Exception {
		return salaryService.getASingleSalary(id);
	}

	@Override
	public List<Salary> getAllEmployeeSalary() {
		return salaryService.getAllEmployeeSalary();
	}

}
