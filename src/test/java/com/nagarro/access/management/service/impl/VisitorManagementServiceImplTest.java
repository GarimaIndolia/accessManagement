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
import com.nagarro.access.management.bean.VisAccessRecord;
import com.nagarro.access.management.bean.Visitor;
import com.nagarro.access.management.repository.EmpAccessRecordRepository;
import com.nagarro.access.management.repository.EmployeeRepository;
import com.nagarro.access.management.repository.VisAccessRecordRepository;
import com.nagarro.access.management.repository.VisitorRepository;

public class VisitorManagementServiceImplTest {

	@Mock
	private VisitorRepository visRepository;
	
	@Mock
	private VisAccessRecordRepository visAccessRecordRepository;
	
	@InjectMocks
	private VisitorManagementServiceImpl ems;	
	
	private Visitor emp;
	
	private VisAccessRecord empRecord;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);		
		emp=new Visitor();
		empRecord=new VisAccessRecord();
		emp.setVisitorId(1l);
		empRecord.setVisAccessRecordId(1l);
		VisAccessRecord empRecord=new VisAccessRecord();
		empRecord.setVisAccessRecordId(1l);
		Optional<Visitor> returnValue = Optional.of((Visitor) emp);
		Mockito.when(visRepository.save(Mockito.anyObject())).thenReturn(emp);
		Mockito.when(visAccessRecordRepository.findAll()).thenReturn(new ArrayList());;
		Mockito.when(visRepository.findById(Mockito.anyLong())).thenReturn(returnValue);        
		Mockito.when(visAccessRecordRepository.save(Mockito.anyObject())).thenReturn(empRecord);
	}
	
	@Test
	public void saveVisTest(){
		ems.saveVisitor(emp);
		assertEquals(emp.getVisitorId(), 1l);
	}
	
	@Test
	public void updateTest(){
		ems.updateVisitor(emp);
		assertEquals(emp.getVisitorId(), 1l);
	}
	
	@Test
	public void findAllVisByConditionsTest(){
		
		assertNotNull(ems.findAllVisByConditions(LocalDateTime.now(), 1l));
	}
	
	@Test
	public void updateVisTimeTest(){
		ems.updateVisTime(empRecord);
		assertEquals(empRecord.getVisAccessRecordId(), 1l);
	}
	
	@Test
	public void findEmpByEmpId(){
		Visitor e=ems.findVisByVisId(1l);
		assertEquals(e.getVisitorId(), 1l);
	}
}
