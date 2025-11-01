package com.qsp.employee_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.employee_management_system.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByemployeeEmail(String employeeEmail);
	
	Employee findByemployeePhone(long employeePhone);
	
	List<Employee> findByEmployeeName(String employeeName);
	
	List<Employee> findByEmployeeAddress(String employeeAddress);
	
	Employee getByemployeeDesignation(String employeeDesignation);
	
	Employee getByemployeeSalary(long employeeSalary);
	
	List<Employee> getByEmployeeGrade(char employeeGarde);
	
	@Query("select e from Employee e where employeeSalary <= ?1")
	List<Employee> findByEmployeeSalaryLessThan(double employeeSalary);
	
	List<Employee> findByEmployeeSalaryGreaterThan(double employeeSalary);
	
	@Query("Select e from Employee e where employeeSalary Between ?1 AND ?2")
	//@Query("Select e from Employee e where employeeSalary>=?1 And employeeSalary<=?2")
	List<Employee> empBySalBetween(double employeeSalary1,double employeeSalary2);
}
