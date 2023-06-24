package com.user.inn.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.inn.mail.service.MailService;
import com.user.mail.model.Mail;



@RestController
@RequestMapping("/email")
@CrossOrigin(origins = {"http://localhost:4200"})
public class Controller {
	
	@Autowired
	MailService service;
	
	
	@GetMapping("/send")
	public String SendMail(@RequestBody Mail mail) {
		System.out.println("Controller.SendMail()"+mail.getSalary());
		service.SendMail(mail);
		return "Salary Credited";
	}
	
}
