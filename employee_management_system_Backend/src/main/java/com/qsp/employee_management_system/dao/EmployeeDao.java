package com.qsp.employee_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo repo;

	public Employee saveEmployee(@RequestBody Employee employee) {
		return repo.save(employee);
	}

//	public String loginEmplyee(String employeeEmail, String employeePassword) {
//		Employee emp = repo.findByemployeeEmail(employeeEmail);
//
//		if (emp != null) {
//			if (emp.getEmployeePassword().equals(employeePassword)) {
//				return "login successful";
//			} else {
//				return null;
//			}
//		} else {
//			return "User Not Registered";
//		}
//	}

	public Employee findEmployee(int employeeId) {
//		return repo.findById(employeeId).get();
		Optional<Employee> emp = repo.findById(employeeId);

		if (emp.isPresent()) {
			return emp.get();
		} else {
			return null;
		}
	}

	public List<Employee> findEmployee() {
		return repo.findAll();
	}

	public List<Employee> saveAll(@RequestBody List<Employee> list) {
		return repo.saveAll(list);
	}

	public Employee findEmployee(long employeePhone) {
		return repo.findByemployeePhone(employeePhone);
	}

	public Employee findEmployee(String employeeEmail) {
		return repo.findByemployeeEmail(employeeEmail);
	}

	public List<Employee> findEmployeeByName(String employeeName) {
		return repo.findByEmployeeName(employeeName);
	}

	public List<Employee> findEmployeeByAddress(String employeeAddress) {
		return repo.findByEmployeeAddress(employeeAddress);
	}

	public Employee findEmployeeByDesignation(String employeeDesignation) {
		return repo.getByemployeeDesignation(employeeDesignation);
	}

//	public Employee updateEmployee(@RequestParam int employeeId, @RequestBody Employee employee) {
//		return repo.save(employee);
//	}
//
//	public Employee updateEmployee(@RequestParam int employeeId, String employeeEmail) {
//		Optional<Employee> emp = repo.findById(employeeId);
//
//		if (emp.isEmpty()) {
//
//			return null;
//		} else {
//			Employee employee = emp.get();
//			employee.setEmployeeEmail(employeeEmail);
//			return repo.save(employee);
//
//		}
//	}

//	public Employee updateEmployee(@RequestParam int employeeId, long employeePhone) {
//		Optional<Employee> emp = repo.findById(employeeId);
//
//		if (emp.isEmpty()) {
//			return null;
//		} else {
//			Employee employee = emp.get();
//			employee.setEmployeePhone(employeePhone);
//			return repo.save(employee);
//		}
//	}
//
//	public Employee updateEmp(@RequestParam int employeeId, String employeeDesignation) {
//		Optional<Employee> emp = repo.findById(employeeId);
//
//		if (emp.isEmpty()) {
//			return null;
//		} else {
//			Employee employee = emp.get();
//			employee.setEmployeeDesignation(employeeDesignation);
//			return repo.save(employee);
//		}
//	}

//	public Employee updateEmp(@RequestParam int employeeId, double employeeSalary) {
//		Optional<Employee> emp = repo.findById(employeeId);
//
//		if (emp.isPresent()) {
//			Employee employee = emp.get();
//			employee.setEmployeeSalary(employeeSalary);
//			return repo.save(employee);
//		} else {
//			return null;
//		}
//	}

//	
//	public Employee deleteEmployee(@RequestParam int employeeId) {
//		Optional<Employee> emp = repo.findById(employeeId);
//		if (emp.isEmpty()) {
//			return null;
//		} else {
//			Employee employee = emp.get();
//			repo.delete(employee);
//			return employee;
//		}
//	}
//
//	public Employee deleteEmployee(long employeePhone) {
//		Employee emp = repo.findByemployeePhone(employeePhone);
//
//		if (emp != null) {
//			repo.delete(emp);
//			return emp;
//		} else {
//			return null;
//		}
//	}
//
//	public Employee deleteEmployee(String employeeAddress) {
//		Employee emp = repo.findByEmployeeAddress(employeeAddress);
//
//		if (emp != null) {
//			repo.delete(emp);
//			return emp;
//		} else {
//			return null;
//		}
//	}
//
//	public Employee deleteEmp(String employeeName) {
//		Employee emp = repo.findByemployeeName(employeeName);
//
//		if (emp == null) {
//
//			return null;
//		} else {
//			repo.delete(emp);
//			return emp;
//		}
//	}
	
	
	public Employee deleteEmployee(@RequestBody Employee employee)
	{
		repo.delete(employee);
		return employee;
	}
	
	public List<Employee> findByGrade(char employeeGrade)
	{
		return repo.getByEmployeeGrade(employeeGrade);
	}
	
	public List<Employee> lessSalary(double employeeSalary)
	{
		return repo.findByEmployeeSalaryLessThan(employeeSalary);
	}
	
	public List<Employee> greaterSalary(double employeeSalary)
	{
		return repo.findByEmployeeSalaryGreaterThan(employeeSalary);
	}
	public List<Employee> betweenSalary(double employeeSalary1,double employeeSalary2)
	{
		return repo.empBySalBetween(employeeSalary1, employeeSalary2);
	}

}
