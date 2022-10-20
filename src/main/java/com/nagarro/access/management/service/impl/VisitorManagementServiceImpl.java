package com.nagarro.access.management.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.nagarro.access.management.bean.VisAccessRecord;
import com.nagarro.access.management.bean.VisAccessRecordSpecification;
import com.nagarro.access.management.bean.Visitor;
import com.nagarro.access.management.repository.VisAccessRecordRepository;
import com.nagarro.access.management.repository.VisitorRepository;
import com.nagarro.access.management.service.VisitorManagementService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VisitorManagementServiceImpl implements VisitorManagementService{

	@Autowired
	private VisitorRepository visitorRepository;
	
	@Autowired
	private VisAccessRecordRepository visAccessRecordRepository;
	
	public Visitor saveVisitor(Visitor visitor) {
		
		return  visitorRepository.save(visitor);
			
		}
		
	public Visitor updateVisitor(Visitor visitor) {
			
			return  visitorRepository.save(visitor);
				
		}
	
	@Override
	public List findAllVisByConditions( LocalDateTime to, Long userId) {
	    
		VisAccessRecord filter=new VisAccessRecord();
		if(userId!=null){
			Visitor emp=new Visitor();
			emp.setVisitorId(userId);		
			filter.setVisitorId(emp);
		}
		filter.setTimeIn(to);
		Specification<VisAccessRecord> spec = new VisAccessRecordSpecification(filter);

		return visAccessRecordRepository.findAll(spec);
	}
		
	public VisAccessRecord updateVisTime(VisAccessRecord vis){
		return	visAccessRecordRepository.save(vis);
		}

	@Override
	public Visitor findVisByVisId(Long userId) {
		
		return visitorRepository.findById(userId).get();
	}

}
