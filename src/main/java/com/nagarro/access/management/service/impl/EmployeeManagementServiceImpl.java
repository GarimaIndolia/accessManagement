package com.nagarro.access.management.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.nagarro.access.management.bean.EmpAccessRecord;
import com.nagarro.access.management.bean.EmpAccessRecordSpecification;
import com.nagarro.access.management.bean.Employee;
import com.nagarro.access.management.repository.EmpAccessRecordRepository;
import com.nagarro.access.management.repository.EmployeeRepository;
import com.nagarro.access.management.service.EmployeeManagementService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeManagementServiceImpl implements EmployeeManagementService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmpAccessRecordRepository empAccessRecordRepository;
	
	public Employee saveEmp(Employee emp) {
		
		return employeeRepository.save(emp);
	}
	
	public Employee updateEmp(Employee emp) {
		
		return employeeRepository.save(emp);
	}
	
	@Override
	public List findAllEmpByConditions( LocalDateTime to, Long userId) {
	    
		EmpAccessRecord filter=new EmpAccessRecord();
		if(userId!=null){
			Employee emp=new Employee();
			emp.setEmpId(userId);		
			filter.setEmpId(emp);
		}
		filter.setTimeIn(to);
		Specification<EmpAccessRecord> spec = new EmpAccessRecordSpecification(filter);

		return empAccessRecordRepository.findAll(spec);
	}
	

	
	public EmpAccessRecord updateEmpTime(EmpAccessRecord emp){
		return empAccessRecordRepository.save(emp);
	}
	
	@Override
	public Employee findEmpByEmpId(Long userId) {
		return employeeRepository.findById(userId).get();
	}



}
