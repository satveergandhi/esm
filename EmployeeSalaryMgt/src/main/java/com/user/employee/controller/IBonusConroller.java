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

import com.user.inn.employee.model.Bonus;

@CrossOrigin(origins = {"http://localhost:4200"})
public interface IBonusConroller {
@PostMapping(path = "/Add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
Bonus Add(@RequestBody Bonus bonus) throws Exception;

@PostMapping(path = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
Bonus Update(@RequestBody Bonus bonus) throws Exception ;

@PostMapping(path = "Delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
String DeleteSalary(@PathVariable("id") Integer id ) throws Exception  ;

@GetMapping(path = "getASingleBonus/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
Bonus getASingleBonus(@PathVariable("id") Integer id ) throws Exception ;

@GetMapping(path = "/getAllEmployeeBonus")
List<Bonus> getAllEmployeeBonus();

}