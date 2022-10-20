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

import com.nagarro.access.management.bean.EmpAccessRecord;
import com.nagarro.access.management.bean.Employee;
import com.nagarro.access.management.constant.Constant;
import com.nagarro.access.management.service.EmployeeManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = Constant.BASE_URL)
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeManagementService empManagementService;

	@PutMapping(value = Constant.CREATE_EMP,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createEmp(@RequestBody Employee emp)  {
		return new ResponseEntity(empManagementService.saveEmp(emp).getEmpId(), HttpStatus.CREATED);
	}
	
	@GetMapping(value = Constant.GET_EMP_AUDIT_INFO,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getEmpAuditInfo(@RequestParam(value="userId",required = false) Long userId, @RequestParam(value="range",required = false) String range)  {
		int timePeriod;
		if(range==null || "".equals(range))
			timePeriod=7;
		else
			timePeriod=Integer.parseInt(range);	
		return new ResponseEntity(empManagementService.findAllEmpByConditions(LocalDateTime.now().minusDays(timePeriod),userId), HttpStatus.OK);
	}
	
	@GetMapping(value = Constant.GET_EMP_DETAILS,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getEmpDetails(@RequestParam(value="userId") Long userId)  {
		return new ResponseEntity(empManagementService.findEmpByEmpId(userId), HttpStatus.OK);
	}

	@PutMapping(value = Constant.UPDATE_EMP_DETAILS,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateEmpDetails(@RequestBody Employee emp)  {
		return new ResponseEntity(empManagementService.updateEmp(emp).getEmpId(), HttpStatus.OK);
	}
	
	@PutMapping(value = Constant.UPDATE_EMP_TIME,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateEmpTime(@RequestBody EmpAccessRecord emp)  {
		return new ResponseEntity(empManagementService.updateEmpTime(emp).getEmpId(), HttpStatus.OK);
	}
	
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity handleError(HttpServletRequest req, Exception ex) {
		  return new ResponseEntity("Internal Server Error has occurred "+ex, HttpStatus.INTERNAL_SERVER_ERROR);

	  }
}
