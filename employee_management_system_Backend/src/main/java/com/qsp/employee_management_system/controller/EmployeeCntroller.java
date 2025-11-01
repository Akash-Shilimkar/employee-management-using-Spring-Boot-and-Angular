package com.qsp.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.service.EmployeeService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class EmployeeCntroller {

	@Autowired
	private EmployeeDao dao;

	@Autowired
	private EmployeeService service;

	@PostMapping("/signup")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@GetMapping("/login")
	public String loginEmployee(String employeeEmail, String employeePassword) {
		return service.loginEmployee(employeeEmail, employeePassword);
	}

	@GetMapping("/find")
	public Employee findEmployee(int employeeId) {
		return service.findEmployee(employeeId);
	}

	
	@PostMapping("save/all")
	public List<Employee> saveAll(@RequestBody List<Employee> list) {
		return service.saveAll(list);
	}
	
	@GetMapping("/find/all")
	public List<Employee> findEmployee() {
		return service.findEmployee();
	}

	@GetMapping("/find/phone")
	public Employee findEmployee(long employeePhone) {
		return dao.findEmployee(employeePhone);
	}

	@GetMapping("/find/email")
	public Employee findEmployee(String employeeEmail) {
		return dao.findEmployee(employeeEmail);
	}

	@GetMapping("/find/name")
	public List<Employee> findEmployeeByName(String employeeName) {
		return service.findEmployeeByName(employeeName);
	}

	@GetMapping("/find/address")
	public List<Employee> findEmployeeByAddress(String employeeAddress) {
		return service.findEmployeeByAddress(employeeAddress);
	}

	@GetMapping("/find/designation")
	public Employee findEmployeeByDesignation(String employeeDesignation) {
		return service.findEmployeeByDesignation(employeeDesignation);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestParam int employeeId, @RequestBody Employee employee) {
		return service.updateEmployee(employeeId, employee);
	}

	@PatchMapping("/update/email")
	public Employee updateEmployee(@RequestParam int employeeId, String employeeEmail) {
		return service.updateEmployee(employeeId, employeeEmail);
	}

	@PatchMapping("/update/phone")
	public Employee updateEmployee(@RequestParam int employeeId, long employeePhone) {
		return service.updateEmployee(employeeId, employeePhone);
	}

	@PatchMapping("/update/designation")
	public Employee updateEmp(@RequestParam int employeeId, String employeeDesignation) {
		return service.updateEmp(employeeId, employeeDesignation);
	}

	@PatchMapping("/update/salary")
	public Employee updateEmp(@RequestParam int employeeId, long employeeSalary) {
		return service.updateEmp(employeeId, employeeSalary);
	}

	@PatchMapping("update/address")
	public Employee updateEmploye(@RequestParam int employeeId, String employeeAddress) {
		return service.updateEmploye(employeeId, employeeAddress);
	}

	@DeleteMapping("/delete/id")
	public Employee deleteEmployee(@RequestParam int employeeId) {
		return service.deleteEmployee(employeeId);
	}

	@DeleteMapping("/delete/phone")
	public Employee deleteEmployee(long employeePhone) {
		return service.deleteEmployee(employeePhone);
	}

	@DeleteMapping("/delete/email")
	public Employee deleteEmployee(String employeeEmail) {
		return service.deleteEmployee(employeeEmail);
	}
	
	@GetMapping("/find/grade")
	public List<Employee> findByGrade(char employeeGrade)
	{
		return service.findByGrade(employeeGrade);
	}
	
	@GetMapping("/lesssalary")
	public List<Employee> lessSalary(double employeeSalary)
	{
		return service.lessSalary(employeeSalary);
	}
	
	@GetMapping("/greatersalary")
	public List<Employee> greaterSalary(double employeeSalary)
	{
		return dao.greaterSalary(employeeSalary);
	}
	
	@GetMapping("/betsal")
	public List<Employee> betweenSalary(double employeeSalary1,double employeeSalary2)
	{
		return service.betweenSalary(employeeSalary1, employeeSalary2);
	}
}
