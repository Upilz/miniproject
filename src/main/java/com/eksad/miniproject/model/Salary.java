package com.eksad.miniproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="salary")
public class Salary {
	
	private Long id;
	private Division division;
	@Column(nullable=false)
	private int salary;
	

}
