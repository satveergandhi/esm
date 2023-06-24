package com.user.inn.employee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "Bonus")
public class Bonus {

	private static final String CATEGORY = "category";

	private static final String CAN_NOT_BE_NULL = "can not be null";

	private static final String Bonus_Type = "Bonus_Type";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	 @ManyToOne(targetEntity = EmployeeDetails.class, fetch = FetchType.EAGER)
//	 @JoinColumn(name = "Employee_Fk", nullable = false)
//	 private EmployeeDetails employee;
//	 
	@ManyToOne
	@JoinColumn(name = "Employee_Fk", nullable = false)
	private EmployeeDetails employee;

	@Column(name = "Bonus", nullable = false, length = 20)
	private long bonus;

	@Column(name = "Date_of_Credited_Bonus", nullable = false, length = 20)
	private Date date;

//	@Enumerated(EnumType.STRING)
//	@Column(name = "BONUS_TYPE")
//	private Category bonustype;

	public enum Bonus_Type {
		MONTHLY, QUATERLY, YEARLY, HALFYEARLY
	}

	@Enumerated(EnumType.STRING)
	//@NotNull(message = Bonus_Type + CAN_NOT_BE_NULL)
	@Column(name = "CATEGORY")
	private Bonus_Type bonus_Type;
}