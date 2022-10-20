package com.nagarro.access.management.integrationTest;

import com.nagarro.access.management.bean.EmpAccessRecord;
import com.nagarro.access.management.bean.Employee;
import com.nagarro.access.management.service.EmployeeManagementService;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerIntTest {

	@Autowired
	private EmployeeManagementService empManagementService;
	
	
	@Test
	public void createEmpTest(){
		Employee emp=new Employee();
		emp.setEmpId(1L);
		assertEquals(empManagementService.saveEmp(emp).getEmpId(),1l);
	}
	
	@Test
	public void getEmpAuditInfoTest(){
		Employee emp=new Employee();
		emp.setEmpId(1L);
		assertNotNull(empManagementService.findAllEmpByConditions(LocalDateTime.now().minusDays(7),1l));
	}
	
	@Test
	public void getEmpDetailsTest(){
		assertNotNull(empManagementService.findEmpByEmpId(1l));
	}
	
	@Test
	public void updateEmpDetailsTest(){
		Employee emp=new Employee();
		emp.setEmpId(1L);
		assertEquals(empManagementService.updateEmp(emp).getEmpId(),1l);
	}
	
	@Test
	public void updateEmpTimeTest(){
		Employee emp=new Employee();
		emp.setEmpId(1L);
		EmpAccessRecord ear=new EmpAccessRecord();;
		ear.setEmpId(emp);
		assertNotNull(empManagementService.updateEmpTime(ear).getEmpId());
	}
}
