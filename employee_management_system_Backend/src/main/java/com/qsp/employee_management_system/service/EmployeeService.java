package com.qsp.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	//1.Save Employee Method
	public Employee saveEmployee(Employee employee) {
		double sal = employee.getEmployeeSalary();

		if (sal <= 10000) {
			employee.setEmployeeGrade('D');
		} else if (sal >= 10000 && sal <= 20000) {
			employee.setEmployeeGrade('C');
		} else if (sal >= 20000 && sal <= 40000) {
			employee.setEmployeeGrade('B');
		} else {
			employee.setEmployeeGrade('A');
		}

		return dao.saveEmployee(employee);
	}
	
	//2. Login Method
	public String loginEmployee(String employeeEmail, String employeePassword)
	{
		Employee emp = dao.findEmployee(employeeEmail);
		if (emp != null) {
			if (emp.getEmployeePassword().equals(employeePassword)) {
					return "login successful";
			} else {
				return null;
				}
			} else {
				return "User Not Registered";
			}
	}
	
	//3.Save All Employee
	public List<Employee> saveAll(List<Employee> list) {
		for (Employee employee : list) {
			double sal = employee.getEmployeeSalary();
			if (sal <= 10000) {
				employee.setEmployeeGrade('D');
			} else if (sal >= 10000 && sal <= 20000) {
				employee.setEmployeeGrade('C');
			} else if (sal >= 20000 && sal <= 40000) {
				employee.setEmployeeGrade('B');
			} else {
				employee.setEmployeeGrade('A');
			}
		}
		return dao.saveAll(list);
	}
	
	//4.Find Employee All Employee
	public List<Employee> findEmployee(){
		List<Employee> list = dao.findEmployee();
		return list; 
		}
	
	//5.Find Employee By ID
	public Employee findEmployee(int employeeId) 
	{
		return dao.findEmployee(employeeId);
	}
	
	//6.Find Employee By Phone 
	public Employee findEmployee(long employeePhone) 
	{
		return dao.findEmployee(employeePhone);
	}
	
	//7.Find Employee By Email 
	public Employee findEmployee(String employeeEmail)
	{
		return dao.findEmployee(employeeEmail);
	}
	
	//8.Find Employee By Name 
	public List<Employee> findEmployeeByName(String employeeName)
		{
			return dao.findEmployeeByName(employeeName);
		}
	
	//9.Find Employee By Address 
	public List<Employee> findEmployeeByAddress(String employeeAddress) {
		return dao.findEmployeeByAddress(employeeAddress);
	}
	
	//10.Find Employee By Designtion 
	public Employee findEmployeeByDesignation(String employeeDesignation) {
		return dao.findEmployeeByDesignation(employeeDesignation);
	}
	
	//11.Update Employee
	public Employee updateEmployee(int employeeId, Employee employee) {
		Employee emp = dao.findEmployee(employeeId);
		if (emp != null) {
			employee.setEmployeeId(employeeId);

			double sal = employee.getEmployeeSalary();

			if (sal <= 10000) {
				employee.setEmployeeGrade('D');
			} else if (sal >= 10000 && sal <= 20000) {
				employee.setEmployeeGrade('C');
			} else if (sal >= 20000 && sal <= 40000) {
				employee.setEmployeeGrade('B');
			} else {
				employee.setEmployeeGrade('A');
			}

			return dao.saveEmployee(employee);
		} else {
			return null;
		}
	}
	
	//12.Update Employee Salary
	public Employee updateEmp(int employeeId, double employeeSalary) {
	
		Employee emp = dao.findEmployee(employeeId);
		
		if(emp != null)
		{
				emp.setEmployeeSalary(employeeSalary);
				
				if (employeeSalary <= 10000) {
					emp.setEmployeeGrade('D');
				} else if (employeeSalary >= 10000 && employeeSalary <= 20000) {
					emp.setEmployeeGrade('C');
				} else if (employeeSalary >= 20000 && employeeSalary <= 40000) {
					emp.setEmployeeGrade('B');
				} else {
					emp.setEmployeeGrade('A');
				}
				
				return dao.saveEmployee(emp);
		}
		else
		{
			return null;
		}
	}
	
	//13.Update Employee email
	public Employee updateEmployee(int employeeId, String employeeEmail)
	{
		Employee emp = dao.findEmployee(employeeId);
		emp.setEmployeeEmail(employeeEmail);
		return dao.saveEmployee(emp);
	}
	
	//14.Update Employee phone
	public Employee updateEmployee(int employeeId, long employeePhone)
	{
		Employee emp = dao.findEmployee(employeeId);
		emp.setEmployeePhone(employeePhone);
		return dao.saveEmployee(emp);
	}
	
	//15.Update Employee Designation
	public Employee updateEmp(int employeeId, String employeeDesignation)
	{
		Employee emp = dao.findEmployee(employeeId);
		emp.setEmployeeDesignation(employeeDesignation);
		return dao.saveEmployee(emp);
	}
	
	//16.Update Employee Address
	public Employee updateEmploye(int employeeId, String employeeAddress)
	{
		Employee emp = dao.findEmployee(employeeId);
		emp.setEmployeeAddress(employeeAddress);
		return dao.saveEmployee(emp);
	}
	
	
	//17.Delete By Id 
	public Employee deleteEmployee(int employeeId)
	{
		Employee emp = dao.findEmployee(employeeId); 
		if (emp == null) {
			return null;
		} else {
			dao.deleteEmployee(emp);
			return emp;
		}
	}
	
	//18.Delete By Phone
	public Employee deleteEmployee(long employeePhone)
	{
		Employee emp = dao.findEmployee(employeePhone); 
		if (emp == null) {
			return null;
		} else {
			dao.deleteEmployee(emp);
			return emp;
		}
	}
	
	//19.Delete By Email
	public Employee deleteEmployee(String employeeEmail)
	{
		Employee emp = dao.findEmployee(employeeEmail); 
		if (emp == null) {
			return null;
		} else {
			dao.deleteEmployee(emp);
			return emp;
		}
	}
	
	//20.Find By Grade
	public List<Employee> findByGrade(char employeeGrade)
	{
		return dao.findByGrade(employeeGrade);
	}
	
	//
	public List<Employee> lessSalary(double employeeSalary)
	{
		return dao.lessSalary(employeeSalary);
	}
	

	public List<Employee> greaterSalary(double employeeSalary)
	{
		return dao.greaterSalary(employeeSalary);
	}
	
	public List<Employee> betweenSalary(double employeeSalary1,double employeeSalary2)
	{
		return dao.betweenSalary(employeeSalary1, employeeSalary2);
	}
}
