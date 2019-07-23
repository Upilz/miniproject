package com.eksad.miniproject.controller;


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


import com.eksad.miniproject.model.Division;
import com.eksad.miniproject.service.DivisionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/miniproject/division")
@Api(tags="Division")
public class DivisionController {
	
	
	@Autowired
	private DivisionService divisionService;
	
	
	//GetAll
	@ApiOperation(value ="API to Retrieve All Mini Project Division's Data " 
			,notes ="Return All  Mini Project Division's Data with JSON Format")
	@GetMapping("getAll")
	public List<Division> getAllDivisions()
	{
		return divisionService.getAllDivisions();
	}
	
	@ApiOperation(value ="API to Retrieve Mini Project Division's Selected Data Based On ID " 
			,notes ="Return Selected  Mini Project Division's Data with JSON Format")
	@GetMapping("getOne/{id}")
	public Division getOne(@RequestBody Division division, @PathVariable Long id)
	{
		return divisionService.getOne(division, id);
	}
	
	@ApiOperation(value ="API to Add/Insert New Mini Project Division's Data" 
			,notes ="Return New  Mini Project Division's Data with JSON Format",
			tags = "Mini Project Data Manipulation API")
	@PostMapping("save")
	public Division save(@RequestBody Division division)
	{
		return divisionService.save(division);
	}
	
	@ApiOperation(value ="API to Update Mini Project Division's Data" 
			,notes ="Update New  Mini Project Division's Data with JSON Format",
			tags = "Mini Project Data Manipulation API")
	@PutMapping("update/{id}")
	public Division update (@RequestBody Division division, @PathVariable Long id)
	{
		return divisionService.update(division, id);
	}
	
	@ApiOperation(value ="API to Delete Selected Mini Project Division's Data" 
			,notes ="Delete Selected Mini Project Division's Data with JSON Format",
			tags = "Mini Project Data Manipulation API")
	@DeleteMapping("delete/{id}")
	public HashMap<String, Object> delete (@RequestBody Division division, @PathVariable Long id)
	{
		return divisionService.delete(division, id);
	}

}
