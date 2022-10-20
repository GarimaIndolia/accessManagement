package com.nagarro.access.management.integrationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.nagarro.access.management.bean.VisAccessRecord;
import com.nagarro.access.management.bean.Visitor;
import com.nagarro.access.management.service.VisitorManagementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitorControllerIntTest {


	@Autowired
	private VisitorManagementService visManagementService;
	
	
	
	
	
	
	@Test
	public void createVisTest(){
		Visitor vis=new Visitor();;
		vis.setVisitorId(1L);
		assertEquals(visManagementService.saveVisitor(vis).getVisitorId(),1l);
	}
	
	@Test
	public void getVisAuditInfoTest(){
		
		assertNotNull(visManagementService.findAllVisByConditions(LocalDateTime.now().minusDays(7l),1l));

	}
	
	@Test
	public void getVisDetailsTest(){
		assertNotNull(visManagementService.findVisByVisId(1l));
	}
	
	@Test
	public void updateVisDetailsTest(){
		Visitor vis=new Visitor();;
		vis.setVisitorId(1L);
		assertEquals(visManagementService.updateVisitor(vis).getVisitorId(),1l);
	}
	
	@Test
	public void updateVisTimeTest(){
		Visitor vis=new Visitor();;
		vis.setVisitorId(1L);
		VisAccessRecord var= new VisAccessRecord();;
		var.setVisitorId(vis);
		assertNotNull(visManagementService.updateVisTime(var).getVisitorId());
	}

}
