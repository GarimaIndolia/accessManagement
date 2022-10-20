package com.nagarro.access.management.integrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.nagarro.access.management.AccessManagementAPIMain;
import com.nagarro.access.management.repository.EmployeeRepository;
import com.nagarro.access.management.service.AccessManagementService;
import com.nagarro.access.management.service.impl.AccessManagementServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessManagementControllerIntTest {

	@Autowired
	private AccessManagementService accessManagementService;
	
	@Test
	public void getAccessTest(){
		boolean access=accessManagementService.isValidAccess(1l);	
		assertEquals(access,true);
	}
}
