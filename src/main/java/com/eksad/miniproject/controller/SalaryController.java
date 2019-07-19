package com.eksad.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.miniproject.RepositoryDAO.SalaryRepositoryDao;
import com.eksad.miniproject.model.Salary;

@RestController
@RequestMapping("/salary")
public class SalaryController {

	@Autowired
	SalaryRepositoryDao salaryDao;
	
	//GetAll
	@GetMapping("getAll")
	public List<Salary> getAll(){
		List<Salary> result = new ArrayList<>();
		salaryDao.findAll().forEach(result::add);
		return result;
	}
	//SAVE-INSERT-DELETE
	@PostMapping("save")
	public Salary save(@RequestBody Salary salary)
	{
		return salaryDao.save(salary);
	}
	
}
