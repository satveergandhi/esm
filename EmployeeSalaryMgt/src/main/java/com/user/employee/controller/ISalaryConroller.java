package com.user.employee.controller;

import java.util.List;
import java.util.Optional;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.inn.employee.model.Salary;

//import io.swagger.annotations.SwaggerDefinition;
//import io.swagger.annotations.Tag;

//@SwaggerDefinition(tags = {
//	    @Tag(name = "ISalaryConroller", description = "REST APIs related to Salary Controller") })
//	@FeignClient(name = "ISalaryConrollerr", url = "${workflow-service.url}", path = "Salary", primary = false)

@CrossOrigin(origins = {"http://localhost:4200"})
public interface ISalaryConroller {

	@PostMapping(path = "Add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Salary Add(@RequestBody Salary salary);

	@PostMapping(path = "Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Salary Update(@RequestBody Salary salary) throws Exception;

	@PostMapping(path = "Delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	String DeleteSalary(@PathVariable("id") Integer id) throws Exception;

	@GetMapping(path = "getASingleSalary/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Salary getASingleSalary(@PathVariable("id") Integer id) throws Exception;

	@GetMapping(path = "/getAllEmployeeSalary")
	List<Salary> getAllEmployeeSalary();

	

}
