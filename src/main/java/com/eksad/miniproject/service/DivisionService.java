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


import com.eksad.miniproject.RepositoryDAO.DivisionRepositoryDao;
import com.eksad.miniproject.model.Division;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DivisionService {

	@Autowired
	private DivisionRepositoryDao  divisionDao;
	@Recover
	public void recover(NumberFormatException ex)
	{	
		log.error("Recover Method-Number Format Exception: {}", ex.getMessage());	
	}
	
	@Recover
	public void recover(NullPointerException ex)
	{
		log.error("Recover Method-Null Format Exception:: {}", ex.getMessage());
	}
	
	@Recover 
	public void recover(Exception e)
	{
		log.error("Recover Method-Exception:: {}", e.getMessage());
	}

	public List<Division> getAllDivisions()
	{
		List<Division> result = new ArrayList<>();
		divisionDao.findAll().forEach(result::add);
		return result;
	}
	
	public Division getOne (Division division, Long id)
	{
		return divisionDao.findById(id).orElse(null);
	}

	//SAVE- UPDATE - DELETE
	
	@Retryable(value = {Exception.class,NumberFormatException.class, NullPointerException.class}, maxAttempts = 3,backoff = @Backoff(5000))
	public Division save(Division division)
	{
		System.out.println("MiniProjects is Calling...");
//		Integer.parseInt("");
//		String str = null ;
//		str.length();
		return divisionDao.save(division);
	}
	
	@Retryable(value = {Exception.class,NumberFormatException.class, NullPointerException.class}, maxAttempts = 3,backoff = @Backoff(5000))
	public Division update (Division division, Long id)
	{

//		Integer.parseInt("");
//		String str = null ;
//		str.length();
		System.out.println("MiniProjects is Calling...");
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

	@Retryable(value = {Exception.class,NumberFormatException.class, NullPointerException.class}, maxAttempts = 3,backoff = @Backoff(5000))
	public HashMap<String, Object> delete (Division division, Long id)
	{
//		Integer.parseInt("");
//		String str = null ;
//		str.length();
		System.out.println("MiniProjects is Calling...");
		HashMap<String, Object> result = new HashMap<String, Object>();
		divisionDao.deleteById(id);
		result.put("message", "Data Succesfully Deleted!");
		return result;
	}
	
	      


	


	
	
	
	
}
