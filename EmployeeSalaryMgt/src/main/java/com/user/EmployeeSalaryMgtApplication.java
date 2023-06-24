package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.user.service.UserService;

@ComponentScan(basePackages = {"com.inn.*"})
@EntityScan("com.user.*")
@SpringBootApplication
public class EmployeeSalaryMgtApplication {
//implements CommandLineRunner
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeSalaryMgtApplication.class, args);
	}

}
