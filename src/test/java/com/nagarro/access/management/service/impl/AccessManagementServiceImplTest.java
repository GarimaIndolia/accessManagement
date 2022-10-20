package com.nagarro.access.management.service.impl;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.access.management.bean.Employee;
import com.nagarro.access.management.repository.EmpAccessRecordRepository;
import com.nagarro.access.management.repository.EmployeeRepository;
import com.nagarro.access.management.repository.VisAccessRecordRepository;
import com.nagarro.access.management.repository.VisitorRepository;

public class AccessManagementServiceImplTest {

	@Mock
	private EmployeeRepository employeeRepository;
	
	@Mock
	private VisitorRepository visitorRepository;
	
	@Mock
	private EmpAccessRecordRepository empAccessRecordRepository;
	
	@Mock
	private VisAccessRecordRepository visAccessRecordRepository;
	
	@InjectMocks
	private AccessManagementServiceImpl ams;
	
	private Employee emp;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		emp=new Employee();
		Optional<Employee> returnValue = Optional.of((Employee) emp);
		Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(returnValue);
			}
		
	@Test
	public void isValidAccessTest(){
	boolean access=	ams.isValidAccess(1l);
		assertEquals(access, true);
	}
	
	@Test
	public void recordPunchTimeTest(){
		ams.recordPunchTime(1l, true);
	}
}
