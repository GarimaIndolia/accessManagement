package com.nagarro.access.management.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.nagarro.access.management.bean.VisAccessRecord;
import com.nagarro.access.management.bean.Visitor;
import com.nagarro.access.management.service.VisitorManagementService;

public class VisitorControllerTest {


	@Mock
	private VisitorManagementService visManagementService;
	
	@InjectMocks
	private VisitorController vc;
	
	Visitor vis;
	VisAccessRecord var;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		vis=new Visitor();
		vis.setVisitorId(1L);
		var= new VisAccessRecord();
		var.setVisitorId(vis);
		Mockito.when(visManagementService.saveVisitor(vis)).thenReturn(vis);
		ArrayList list=new ArrayList();
		Mockito.when(visManagementService.findAllVisByConditions(LocalDateTime.now().minusDays(Mockito.anyInt()),Mockito.anyLong())).thenReturn(list);
		Mockito.when(visManagementService.findVisByVisId(Mockito.anyLong())).thenReturn(vis);
		Mockito.when(visManagementService.updateVisitor(vis)).thenReturn(vis);
		Mockito.when(visManagementService.updateVisTime(var)).thenReturn(var);
	}
	
	@Test
	public void createVisTest(){
		ResponseEntity re=vc.createTempAccessId(vis);
		assertEquals(re.getBody(),1l);
	}
	
	@Test
	public void getVisAuditInfoTest(){
		ResponseEntity re=vc.getVisAuditInfo(1l, null);
		assertNotNull(re.getBody());
	}
	
	@Test
	public void getVisDetailsTest(){
		ResponseEntity re=vc.getVisDetails(1l);
		assertNotNull(re.getBody());
	}
	
	@Test
	public void updateVisDetailsTest(){
		ResponseEntity re=vc.updateVisDetails(vis);
		assertEquals(re.getBody(),1l);
	}
	
	@Test
	public void updateVisTimeTest(){
		ResponseEntity re=vc.updateVisTime(var);
		assertNotNull(re.getBody());
	}

}
