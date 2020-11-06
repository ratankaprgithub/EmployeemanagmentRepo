package com.ratan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long empId;
	
	

	@Size(min=3,max=12,message = "Name lenght must be min 3 and max 12")
	private String name;
	

	@Size(min=3,max=30,message = "Address length must be min 5 and max 30")
	private String address;

	@Email(message = "please pass proper Email")
	private String email;
	
	@Min(value = 5000,message = "Salary minimum is 5000")
	@Max(value =  1000000,message = "salary maximum is 100000")
	private Integer salary;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public Long getEmpId() {
		return empId;
	}


	public void setEmpId(Long empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public Employee(Long empId, String name, String address, String email, Integer salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.salary = salary;
	}
	
	
}
