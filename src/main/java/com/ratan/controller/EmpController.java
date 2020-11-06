package com.ratan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ratan.model.Employee;
import com.ratan.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmpController {

	@Autowired
	EmployeeService empService;

	@GetMapping("/")
	public List<Employee> home() {

		return empService.getAllEmployees();
		
	}

	
	@PostMapping(value = "/addEmployee",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmployeeHome(@Valid @RequestBody Employee employee) {
		 Employee emp=empService.registerEmployee(employee);
		return emp;
	}

	
	  @PutMapping(value = "/updateEmployee",consumes = MediaType.APPLICATION_JSON_VALUE) 
	  public Employee updateEmployee(@Valid @RequestBody Employee employee) {
	  
		  Employee emp=empService.updateEmployee(employee);
		  return emp;
		  }
	  
	  
	  @DeleteMapping("/deleteEmployee/{empId}")
	  public List<Employee> deleteEmployee(@PathVariable Long empId) {
		  
		 return empService.deleteEmployee(empId);
		  
	  }
	  
	  @GetMapping("/getEmployeeById/{empId}")
	  public Employee getEmployee(@PathVariable Long empId) {
		  
		  return empService.getEmployeeById(empId);
		  
	  }
		
		
	  

}
