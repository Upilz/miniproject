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
import com.eksad.miniproject.service.GetOneIdService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/miniproject/employee")
@Api(tags="Employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value ="API to Retrieve All Mini Project Employee's Data " 
			,notes ="Return All  Mini Project Employee's Data with JSON Format")
	@GetMapping("getAll")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@ApiOperation(value ="API to Retrieve Mini Project Employee's Selected Data Based on ID " 
			,notes ="Return Selected Mini Project Employee's Based on ID Data with JSON Format")
	@GetMapping("getOne/{id}")
	public Employee getOne(@RequestBody Employee employee,@PathVariable Long id)
	{
		return employeeService.getOne(employee, id);
	}
	
	@ApiOperation(value ="API to Add/Insert New Mini Project Employee's Data", 
			notes ="Return New Mini Project Employee's Data",
			tags = "Mini Project Data Manipulation API")
	@PostMapping("save")
	public Employee save(@RequestBody Employee employee)
	{
		return employeeService.save(employee);
	}
	
	@ApiOperation(value ="API to Update Mini Project Employee's Data", 
			notes ="Update New Mini Project Employee's Data",
			tags = "Mini Project Data Manipulation API")
	@PutMapping("update/{id}")
	public Employee update (@RequestBody Employee employee, @PathVariable Long id)
	{
		return employeeService.update(employee, id);
	}
	
	@ApiOperation(value ="API to Delete Selected Mini Project Employee's Data", 
			notes ="Delete Selected Mini Project Employee's Data",
			tags = "Mini Project Data Manipulation API")
	@DeleteMapping("delete/{id}")
	public HashMap<String, Object> delete (@RequestBody Employee employee, @PathVariable Long id)
	{
		return employeeService.delete(employee, id);
	}

}
