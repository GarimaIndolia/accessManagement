package com.nagarro.access.management.controller;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.nagarro.access.management.service.AccessManagementService;

public class AccessManagementControllerTest {

	@InjectMocks
	private AccessManagementController amc;
	
	@Mock
	private AccessManagementService accessManagementService;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		Mockito.when(accessManagementService.isValidAccess(Mockito.anyLong())).thenReturn(true);
	}
	
	@Test
	public void getAccessTest(){
		ResponseEntity re=amc.getAccess(1l, true);	
		assertEquals(re.getBody(),true);
	}
}
