package com.eksad.miniproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.eksad.miniproject.RepositoryDAO.DivisionRepositoryDao;
import com.eksad.miniproject.model.Division;

@Service
public class DivisionService {

	@Autowired
	private DivisionRepositoryDao  divisionDao;
	
		
	public List<Division> getAllDivisions()
	{
		List<Division> result = new ArrayList<>();
		divisionDao.findAll().forEach(result::add);
		return result;
	}
	
	//SAVE- UPDATE - DELETE
	public Division save(Division division)
	{
		return divisionDao.save(division);
	}
	
	public Division update (Division division, Long id)
	{
		Division divisionSelected = divisionDao.findById(id).orElse(null);
		if( divisionSelected != null)
		{
			divisionSelected.setName(division.getName());
			
			return divisionDao.save(divisionSelected);
		}
		else
		{
			return null;
		}
	}
	
	public HashMap<String, Object> delete (Division division, Long id)
	{
		HashMap<String, Object> result = new HashMap<String, Object>();
		divisionDao.deleteById(id);
		result.put("message", "Data Succesfully Deleted!");
		return result;
	}
	
	      


	


	
	
	
	
}
