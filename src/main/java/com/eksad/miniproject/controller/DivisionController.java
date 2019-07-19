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

@RestController
@RequestMapping("/division")
public class DivisionController {
	@Autowired
	DivisionRepositoryDao divisionDao;
	
	//GetAll
	@GetMapping("getAll")
	public List<Division> getAll(){
		List<Division> result = new ArrayList<>();
		divisionDao.findAll().forEach(result::add);
		return result;
	}
	//Save-Insert-Delete
	@PostMapping(value="save")
	public Division save (@RequestBody Division division)
	{
		return divisionDao.save(division);
	}
	@PutMapping("update/{id}")
	public Division update (@RequestBody Division division, @PathVariable Long id) {
		Division divisionselected = divisionDao.findById(id).orElse(null);
		if(divisionselected != null)
		{
			divisionselected.setName(division.getName());
			return divisionDao.save(divisionselected);
		}
		else {
			return null;
		}
	}
	@DeleteMapping("delete/{id}")
	public HashMap<String, Object> delete (@PathVariable Long id)
	{
		HashMap<String, Object> result = new HashMap<String, Object>();
		divisionDao.deleteById(id);
		result.put("message", "delete data successfully");
		return result;
	}
	

}
