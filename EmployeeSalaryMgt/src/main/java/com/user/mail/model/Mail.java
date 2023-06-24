package com.user.mail.model;

public class Mail {
	private String Name;
	private String Email;
	private String Salary;
	private String Subject;
	private String Message;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}
	
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	public Mail(String name, String email, String salary, String subject, String message) {
		super();
		Name = name;
		Email = email;
		Salary = salary;
		Subject = subject;
		Message = message;
	}
	public Mail() {
		super();
	}
	
	
}
