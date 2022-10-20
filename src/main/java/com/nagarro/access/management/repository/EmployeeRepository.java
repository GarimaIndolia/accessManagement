package com.nagarro.access.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.access.management.bean.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long >{
	
}
