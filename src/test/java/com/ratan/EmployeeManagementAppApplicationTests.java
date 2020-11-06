package com.ratan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ratan.model.Employee;
import com.ratan.repository.EmployeeRepository;
import com.ratan.service.EmployeeService;

@SpringBootTest
class EmployeeManagementAppApplicationTests {

	@MockBean
	EmployeeRepository empRepo;

	@Autowired
	EmployeeService empService;

	@Test
	public void testregisterEmployee() {

		Employee employee = new Employee(10L, "Ram", "Kolkata", "ra@123", 85000);

		Mockito.when(empRepo.save(employee)).thenReturn(employee);

		Employee emp = empService.registerEmployee(employee);

		assertEquals(employee.getName(), emp.getName());
	}
	

	@Test
	public void testGetAllEmployees() {

		Mockito.when(empRepo.findAll())
				.thenReturn(Stream
						.of(new Employee(10L, "Ram", "delhi", "ram@gmail.com", 9000),
								new Employee(12L, "Ravi", "chennai", "ravi@gmail.com", 9500))
						.collect(Collectors.toList()));

		assertEquals(2, empService.getAllEmployees().size());
	}
	
	
	@Test
	public void testGetEmployeeById() {

		Mockito.when(empRepo.findById(10L))
				.thenReturn(Optional.of(new Employee(10L, "Ram", "delhi", "ram@gmail.com", 95000)));

		assertEquals("Ram",empService.getEmployeeById(10L).getName());
	}
	
	
	
	
	
	
	
	
	

}
