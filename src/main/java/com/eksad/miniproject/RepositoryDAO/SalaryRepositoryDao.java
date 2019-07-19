package com.eksad.miniproject.RepositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eksad.miniproject.model.Salary;

public interface SalaryRepositoryDao extends JpaRepository<Salary, Long>{

}
