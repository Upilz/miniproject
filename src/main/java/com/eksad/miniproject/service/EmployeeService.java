package com.eksad.miniproject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eksad.miniproject.RepositoryDAO.EmployeeRepositoryDao;
import com.eksad.miniproject.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepositoryDao employeeDao;

	public List<Employee> getAllEmployees()
	{
		List<Employee> result = new ArrayList<>();
		employeeDao.findAll().forEach(result::add);
		return result;
	}
	
	//SAVE - UPDATE -DELETE 
	public Employee save (Employee employee)
	{
		return employeeDao.save(employee);
	}
	
	public Employee update(Employee employee, Long id)
	{
		Employee employeeSelected = employeeDao.findById(id).orElse(null);
		if(employeeSelected != null)
		{
			employeeSelected.setName(employee.getName());
			employeeSelected.setDob(employee.getDob());
			employeeSelected.setAddress(employee.getAddress());
			employeeSelected.setPhone(employee.getPhone());
			employeeSelected.setAge(employee.getAge());
			employeeSelected.setPob(employee.getPob());
			employeeSelected.setId_salary(employee.getId_salary());
			employeeSelected.setId_div(employee.getId_div());
			
			return employeeDao.save(employeeSelected);
		}
		else {
			return null;
		}
	}
	
	public HashMap<String, Object> delete (Employee employee, Long id)
	{
		HashMap<String, Object> result = new HashMap<String, Object>();
		employeeDao.deleteById(id);
		result.put("message", "Data Successfully Delete");
		return result;
	}
}
