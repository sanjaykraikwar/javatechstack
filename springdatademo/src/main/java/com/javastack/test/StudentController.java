package com.javastack.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class StudentController {
	
	@Autowired
	EmployeeRepository repository;
	
	@GetMapping(path="/emp/save" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee saveEmp(){
		Employee e= new Employee();
		e.setId(102);
		e.setName("sanjay");
		return repository.save(e);
	}
	@GetMapping(path="/" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String getMsg(){
		return "hello";
	}

	
	@RequestMapping("/emp")
	public Optional<Employee> getEmp(){
		
		return repository.findById(102);
	}
	
	@RequestMapping("/emp/all")
	public List<Employee> getEmployees(){
		
		return repository.findAll();
	}
}
