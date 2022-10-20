package com.nagarro.access.management.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

import com.nagarro.access.management.bean.EmpAccessRecord;
import com.nagarro.access.management.bean.Employee;
import com.nagarro.access.management.repository.EmpAccessRecordRepository;
import com.nagarro.access.management.repository.EmployeeRepository;

public class EmployeeManagementServiceImplTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@Mock
	private EmpAccessRecordRepository empAccessRecordRepository;
	
	@InjectMocks
	private EmployeeManagementServiceImpl ems;	
	
	private Employee emp;
	
	private EmpAccessRecord empRecord;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);		
		emp=new Employee();
		empRecord=new EmpAccessRecord();
		emp.setEmpId(1l);
		empRecord.setEmpAccessRecordId(1l);
		EmpAccessRecord empRecord=new EmpAccessRecord();
		empRecord.setEmpAccessRecordId(1l);
		Optional<Employee> returnValue = Optional.of((Employee) emp);
		Mockito.when(employeeRepository.save(Mockito.anyObject())).thenReturn(emp);
		Mockito.when(empAccessRecordRepository.findAll((Specification<EmpAccessRecord>)Mockito.anyObject())).thenReturn(new ArrayList());;
		Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(returnValue);        
		Mockito.when(empAccessRecordRepository.save(Mockito.anyObject())).thenReturn(empRecord);
	}
	
	@Test
	public void saveEmpTest(){
		ems.saveEmp(emp);
		assertEquals(emp.getEmpId(), 1l);
	}
	
	@Test
	public void updateEmpTest(){
		ems.updateEmp(emp);
		assertEquals(emp.getEmpId(), 1l);
	}
	
	@Test
	public void findAllEmpByConditionsTest(){
		
		assertNotNull(ems.findAllEmpByConditions(LocalDateTime.now(), 1l));
	}
	
	@Test
	public void updateEmpTimeTest(){
		ems.updateEmpTime(empRecord);
		assertEquals(empRecord.getEmpAccessRecordId(), 1l);
	}
	
	@Test
	public void findEmpByEmpId(){
		Employee e=ems.findEmpByEmpId(1l);
		assertEquals(e.getEmpId(), 1l);
	}
}
