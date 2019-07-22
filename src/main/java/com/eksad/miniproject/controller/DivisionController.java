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

import com.eksad.miniproject.RepositoryDAO.DivisionRepositoryDao;
import com.eksad.miniproject.model.Division;
import com.eksad.miniproject.service.DivisionService;

@RestController
@RequestMapping("/division")
public class DivisionController {
	
	
	@Autowired
	private DivisionService divisionService;
	
	//GetAll
	@GetMapping("getAll")
	public List<Division> getAllDivisions()
	{
		return divisionService.getAllDivisions();
	}
	
	@PostMapping("save")
	public Division save(@RequestBody Division division)
	{
		return divisionService.save(division);
	}
	
	@PutMapping("update/{id}")
	public Division update (@RequestBody Division division, @PathVariable Long id)
	{
		return divisionService.update(division, id);
	}
	
	@DeleteMapping("delete/{id}")
	public HashMap<String, Object> delete (@RequestBody Division division, @PathVariable Long id)
	{
		return divisionService.delete(division, id);
	}

}
