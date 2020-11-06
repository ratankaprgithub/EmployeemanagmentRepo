package com.ratan.service;

import java.util.List;

import com.ratan.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee registerEmployee(Employee employee);
	
	public Employee getEmployeeById(Long empId);
	

	public Employee updateEmployee(Employee employee);
	
	public List<Employee> deleteEmployee(Long empId);
	

}
