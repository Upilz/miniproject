package com.eksad.miniproject.RepositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eksad.miniproject.model.Employee;

public interface EmployeeRepositoryDao extends JpaRepository<Employee, Long> {

}
