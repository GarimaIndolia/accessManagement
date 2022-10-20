package com.nagarro.access.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nagarro.access.management.bean.EmpAccessRecord;
import com.nagarro.access.management.bean.VisAccessRecord;
import com.nagarro.access.management.bean.Visitor;



public interface VisAccessRecordRepository extends JpaRepository<VisAccessRecord,Long >, JpaSpecificationExecutor<VisAccessRecord>{

	List<VisAccessRecord> findByVisitorIdOrderByTimeInDesc(Visitor v);
}
