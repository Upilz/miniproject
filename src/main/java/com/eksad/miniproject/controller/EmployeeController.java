package com.eksad.miniproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.miniproject.RepositoryDAO.EmployeeRepositoryDao;
import com.eksad.miniproject.model.Employee;
import com.eksad.miniproject.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("getAll")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	@PostMapping("save")
	public Employee save(@RequestBody Employee employee)
	{
		return employeeService.save(employee);
	}
	@PutMapping("update/{id}")
	public Employee update (@RequestBody Employee employee, @PathVariable Long id)
	{
		return employeeService.update(employee, id);
	}
	@DeleteMapping("delete/{id}")
	public HashMap<String, Object> delete (@RequestBody Employee employee, @PathVariable Long id)
	{
		return employeeService.delete(employee, id);
	}

}
