package com.eksad.miniproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.eksad.miniproject.RepositoryDAO.DivisionRepositoryDao;
import com.eksad.miniproject.model.Division;


@Service
public class DivisionService {

	@Autowired
	private DivisionRepositoryDao  divisionDao;
	
	@Retryable(value = {Exception.class,NumberFormatException.class, NullPointerException.class}, maxAttempts = 3,backoff = @Backoff(10000))
	public List<Division> getAllDivisions()
	{
		System.out.println("My API is Calling...");
//		String str = null ;
//			str.length();
//		Integer.parseInt("");
			
		List<Division> result = new ArrayList<>();
		divisionDao.findAll().forEach(result::add);
		return result;
		
	}
	
	@Recover
	public List<Division> recover(NumberFormatException ex)
	{
		System.out.println("Recover Method - Number Format   Exception");
		List<Division> result = new ArrayList<>();
		divisionDao.findAll().forEach(result::add);
		return result;
	}
	
	@Recover
	public List<Division> recover(NullPointerException ex)
	{
		System.out.println("Recover Method - Null Pointer   Exception");
		List<Division> result = new ArrayList<>();
		divisionDao.findAll().forEach(result::add);
		return result;
	}
	
	@Recover 
	public List<Division> recover(Exception e)
	{
		System.out.println("Recover Method - Exception Class");
		List<Division> result = new ArrayList<>();
		divisionDao.findAll().forEach(result::add);
		return result;
	}
	
	public Division getOne (Division division, Long id)
	{
		System.out.println("My API is Calling...");
		return divisionDao.findById(id).orElse(null);
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
