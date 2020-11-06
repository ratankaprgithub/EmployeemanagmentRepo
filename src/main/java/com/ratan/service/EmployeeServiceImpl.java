package com.ratan.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ratan.exceptions.EmployeeNotFoundException;
import com.ratan.model.Employee;
import com.ratan.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository empRepo;
	
	
	@Override
	public List<Employee> getAllEmployees() {
	
		
		
		List<Employee> employess=empRepo.findAll();
		return employess;
	}


	@Override
	public Employee registerEmployee(Employee employee) {
		
		
		Employee emp= empRepo.save(employee);
		
			
		return emp;
	}


	@Override
	public Employee getEmployeeById(Long empId) {
		
		Employee employee=null;
		
		Optional<Employee> opt=empRepo.findById(empId);
		
		if(opt.isPresent())
			employee=opt.get();
		else
			throw new EmployeeNotFoundException("Employee not Found with given Id");
		
		return employee;
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		
		Employee emp=empRepo.save(employee);
		
		return emp;
	}


	@Override
	public List<Employee> deleteEmployee(Long empId) {
		
		empRepo.deleteById(empId);
		
		return getAllEmployees();
	}
	
	

	
	
	
	
	
	
	
}
