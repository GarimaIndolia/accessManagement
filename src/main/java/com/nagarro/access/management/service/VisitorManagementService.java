package com.nagarro.access.management.service;

import java.time.LocalDateTime;
import java.util.List;

import com.nagarro.access.management.bean.VisAccessRecord;
import com.nagarro.access.management.bean.Visitor;

public interface VisitorManagementService {

	public VisAccessRecord updateVisTime(VisAccessRecord vis);

	public List findAllVisByConditions(LocalDateTime to, Long userId);

	public Visitor findVisByVisId(Long userId);
	
	public Visitor updateVisitor(Visitor vis);
	
	public Visitor saveVisitor(Visitor vis);
}
