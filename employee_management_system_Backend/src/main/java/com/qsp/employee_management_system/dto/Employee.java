package com.qsp.employee_management_system.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String employeeName;
	@Column(unique = true)
	private long employeePhone;
	private String employeeAddress;
	@Column(unique = true)
	private String employeeEmail;
	private String employeeDesignation;
	private double employeeSalary;
	private char employeeGrade;
	private String employeePassword;
	
}
