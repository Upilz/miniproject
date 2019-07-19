package com.eksad.miniproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="division")
public class Division {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
}
