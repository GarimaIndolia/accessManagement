package com.nagarro.access.management.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.access.management.constant.Constant;
import com.nagarro.access.management.service.AccessManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = Constant.BASE_URL)
@Slf4j
public class AccessManagementController {
	
	@Autowired
	private AccessManagementService accessManagementService;

	@PutMapping(value = Constant.CREATE_MEM_ACCESS)
	public ResponseEntity getAccess(@PathVariable final Long accessId,@PathVariable final boolean isPunchIn)  {
		boolean isValidAccess =accessManagementService.isValidAccess(accessId);
		if(isValidAccess)
			accessManagementService.recordPunchTime(accessId,isPunchIn);
		return new ResponseEntity(isValidAccess, HttpStatus.OK);
	}

	 @ExceptionHandler(Exception.class)
	  public ResponseEntity handleError(HttpServletRequest req, Exception ex) {
		  return new ResponseEntity("Internal Server Error has occurred "+ex, HttpStatus.INTERNAL_SERVER_ERROR);

	  }
}
