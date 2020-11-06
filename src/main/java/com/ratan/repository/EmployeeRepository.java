package com.ratan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ratan.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{


	List<Employee> findByName(String name);
	
	
	@Query("select e.name from Employee e where e.empId=?1")
	public String getEmployeeNameById(int id);
	
}
