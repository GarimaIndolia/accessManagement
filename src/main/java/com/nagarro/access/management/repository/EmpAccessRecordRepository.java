package com.nagarro.access.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nagarro.access.management.bean.EmpAccessRecord;
import com.nagarro.access.management.bean.Employee;

public interface EmpAccessRecordRepository extends JpaRepository<EmpAccessRecord,Long >, JpaSpecificationExecutor<EmpAccessRecord>{

	List<EmpAccessRecord> findByEmpIdOrderByTimeInDesc(Employee temp);
}
