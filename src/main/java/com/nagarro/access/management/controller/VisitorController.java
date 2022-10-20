package com.nagarro.access.management.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.access.management.bean.VisAccessRecord;
import com.nagarro.access.management.bean.Visitor;
import com.nagarro.access.management.constant.Constant;
import com.nagarro.access.management.service.EmployeeManagementService;
import com.nagarro.access.management.service.VisitorManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = Constant.BASE_URL)
@Slf4j
public class VisitorController {
	
	@Autowired
	private VisitorManagementService visManagementService;

	@PutMapping(value = Constant.CREATE_TEMP_ACCESS_ID,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createTempAccessId(@RequestBody Visitor visitor)  {
		return new ResponseEntity(visManagementService.saveVisitor(visitor).getVisitorId(), HttpStatus.CREATED);
	}
	

	
	@GetMapping(value = Constant.GET_VIS_AUDIT_INFO,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getVisAuditInfo(@RequestParam(value="userId",required = false) Long userId, @RequestParam(value="range",required = false) String range)  {
		int timePeriod;
		if(range==null || "".equals(range))
			timePeriod=7;
		else
			timePeriod=Integer.parseInt(range);
		return new ResponseEntity(visManagementService.findAllVisByConditions(LocalDateTime.now().minusDays(timePeriod),userId), HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = Constant.GET_VIS_DETAILS,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getVisDetails(@RequestParam(value="userId") Long userId)  {
		return new ResponseEntity(visManagementService.findVisByVisId(userId), HttpStatus.OK);
	}
	
	
	
	@PutMapping(value = Constant.UPDATE_VIS_DETAILS,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateVisDetails(@RequestBody Visitor vis)  {
		return new ResponseEntity(visManagementService.updateVisitor(vis).getVisitorId(), HttpStatus.OK);
	}
	
	
	@PutMapping(value = Constant.UPDATE_VIS_TIME,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateVisTime(@RequestBody VisAccessRecord vis)  {
		return new ResponseEntity(visManagementService.updateVisTime(vis).getVisitorId(), HttpStatus.OK);
	}
	
		
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity handleError(HttpServletRequest req, Exception ex) {
		  return new ResponseEntity("Internal Server Error has occurred "+ex, HttpStatus.INTERNAL_SERVER_ERROR);

	  }
}
