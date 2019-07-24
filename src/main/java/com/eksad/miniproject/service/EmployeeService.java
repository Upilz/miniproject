package com.eksad.miniproject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.eksad.miniproject.RepositoryDAO.EmployeeRepositoryDao;
import com.eksad.miniproject.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	
	@Autowired
	private EmployeeRepositoryDao employeeDao;
	@Recover
	public void recover(NullPointerException ex)
	{
		log.error("Recover Method-Null Pointer Exception:: {}", ex.getMessage());
	}
	@Recover
	public void recover(NumberFormatException ex)
	{
		log.error("Recover Method-Number Format Exception:: {}\", ex.getMessage()");
	}
	@Recover
	public void recover (Exception e)
	{
		log.error("Recover Method-Exception:: {}\", ex.getMessage()");
	}
	
	public List<Employee> getAllEmployees() 
	{
		
		List<Employee> result = new ArrayList<>();
		employeeDao.findAll().forEach(result::add);
		return result;
	}
	
	public Employee getOne(Employee employee, Long id) {
		return employeeDao.findById(id).orElse(null);
	}
	
	
	//SAVE - UPDATE -DELETE 
	@Retryable(value={Exception.class,NullPointerException.class,NumberFormatException.class},
			maxAttempts = 3, backoff = @Backoff(5000))
	public Employee save (Employee employee)
	{
		System.out.println("MiniProject's is calling...");
//		Integer.parseInt("");
//		String str = null ;
//		str.length();
		return employeeDao.save(employee);
	}
	
	@Retryable(value={Exception.class,NullPointerException.class,NumberFormatException.class},
			maxAttempts = 3, backoff = @Backoff(5000))
	public Employee update(Employee employee, Long id)
	{
		System.out.println("MiniProject's is calling...");
//		Integer.parseInt("");
//		String str = null ;
//		str.length();
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
	
	@Retryable(value={Exception.class,NullPointerException.class,NumberFormatException.class},
			maxAttempts = 3, backoff = @Backoff(5000))
	public HashMap<String, Object> delete (Employee employee, Long id)
	{
		System.out.println("MiniProject's is calling...");
//		Integer.parseInt("");
//		String str = null ;
//		str.length();
		HashMap<String, Object> result = new HashMap<String, Object>();
		employeeDao.deleteById(id);
		result.put("message", "Data Successfully Delete");
		return result;
	}
}
