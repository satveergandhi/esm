package com.user.inn.employee.model;

import java.util.Date;

import javax.persistence.*;

//import com.inn.product.um.employeedetail.model.EmployeeDetail;

import lombok.Data;

@Entity
@Table(name = "Salary")
@Data
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private EmployeeDetails employee;
	@JoinColumn(name = "Employee_Fk", nullable = false)

	@Column(name = "Salary", nullable = false, length = 20)
	private String salary;

	@Column(name = "Date_of_Credited_Salary", nullable = false, length = 20)
	private Date date;
	


}