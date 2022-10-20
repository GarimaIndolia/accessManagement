package com.nagarro.access.management.controller;

import com.nagarro.access.management.bean.EmpAccessRecord;
import com.nagarro.access.management.bean.Employee;
import com.nagarro.access.management.service.EmployeeManagementService;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class EmployeeControllerTest {

	@Mock
	private EmployeeManagementService empManagementService;
	
	@InjectMocks
	private EmployeeController ec;
	
	Employee emp;
	EmpAccessRecord ear;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		emp=new Employee();
		emp.setEmpId(1L);
		ear= new EmpAccessRecord();
		ear.setEmpId(emp);
		Mockito.when(empManagementService.saveEmp(emp)).thenReturn(emp);
		ArrayList list=new ArrayList();
		Mockito.when(empManagementService.findAllEmpByConditions(LocalDateTime.now().minusDays(Mockito.anyInt()),Mockito.anyLong())).thenReturn(list);
		Mockito.when(empManagementService.findEmpByEmpId(Mockito.anyLong())).thenReturn(emp);
		Mockito.when(empManagementService.updateEmp(emp)).thenReturn(emp);
		Mockito.when(empManagementService.updateEmpTime(ear)).thenReturn(ear);
	}
	
	@Test
	public void createEmpTest(){
		ResponseEntity re=ec.createEmp(emp);
		assertEquals(re.getBody(),1l);
	}
	
	@Test
	public void getEmpAuditInfoTest(){
		ResponseEntity re=ec.getEmpAuditInfo(1l, null);
		assertNotNull(re.getBody());
	}
	
	@Test
	public void getEmpDetailsTest(){
		ResponseEntity re=ec.getEmpDetails(1l);
		assertNotNull(re.getBody());
	}
	
	@Test
	public void updateEmpDetailsTest(){
		ResponseEntity re=ec.updateEmpDetails(emp);
		assertEquals(re.getBody(),1l);
	}
	
	@Test
	public void updateEmpTimeTest(){
		ResponseEntity re=ec.updateEmpTime(ear);
		assertNotNull(re.getBody());
	}
}
