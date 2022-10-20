package com.nagarro.access.management.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.nagarro.access.management.bean.EmpAccessRecord;
import com.nagarro.access.management.bean.EmpAccessRecordSpecification;
import com.nagarro.access.management.bean.Employee;
import com.nagarro.access.management.bean.VisAccessRecord;
import com.nagarro.access.management.bean.VisAccessRecordSpecification;
import com.nagarro.access.management.bean.Visitor;
import com.nagarro.access.management.repository.EmpAccessRecordRepository;
import com.nagarro.access.management.repository.EmployeeRepository;
import com.nagarro.access.management.repository.VisAccessRecordRepository;
import com.nagarro.access.management.repository.VisitorRepository;
import com.nagarro.access.management.service.AccessManagementService;
import com.nagarro.access.management.service.EmployeeManagementService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccessManagementServiceImpl implements AccessManagementService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	@Autowired
	private EmpAccessRecordRepository empAccessRecordRepository;
	
	@Autowired
	private VisAccessRecordRepository visAccessRecordRepository;
	
	public boolean isValidAccess(Long accessId) {
		if(employeeRepository.findById(accessId).isPresent())  
		{	
			return true;
		}
		if(visitorRepository.findById(accessId).isPresent()) 
		{	
			return true;
		}	
		return false;
	}

	
	
	public void recordPunchTime(Long accessId, boolean isPunchIn) {
		if(employeeRepository.findById(accessId).isPresent())  
		{	
			EmpAccessRecord record;
			if(isPunchIn){
				record= new EmpAccessRecord();
				record.setTimeIn(LocalDateTime.now());
				
			}
			else
			{
				Employee temp=new Employee();
				temp.setEmpId(accessId);
				record=empAccessRecordRepository.findByEmpIdOrderByTimeInDesc(temp).get(0);
				record.setTimeOut(LocalDateTime.now());
				
			}
			record.setEmpId(employeeRepository.findById(accessId).get());
			empAccessRecordRepository.save(record);
						
		}
		if(visitorRepository.findById(accessId).isPresent()) 
		{	
			VisAccessRecord record;
			if(isPunchIn){
				record= new VisAccessRecord();
				record.setTimeIn(LocalDateTime.now());
				
			}
			else
			{	Visitor temp=new Visitor();
				temp.setVisitorId(accessId);
				record=visAccessRecordRepository.findByVisitorIdOrderByTimeInDesc(temp).get(0);
				record.setTimeOut(LocalDateTime.now());
				
			}
			record.setVisitorId(visitorRepository.findById(accessId).get());
			visAccessRecordRepository.save(record);
						
		}	
	}

	
	

	
	

	
	
	
	
	
	
	
}
