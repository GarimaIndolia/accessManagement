package com.nagarro.access.management.service;

import java.time.LocalDateTime;
import java.util.List;

import com.nagarro.access.management.bean.EmpAccessRecord;
import com.nagarro.access.management.bean.Employee;
import com.nagarro.access.management.bean.VisAccessRecord;
import com.nagarro.access.management.bean.Visitor;

public interface EmployeeManagementService {


public List findAllEmpByConditions(LocalDateTime to, Long userId);

public EmpAccessRecord updateEmpTime(EmpAccessRecord emp);

public Employee findEmpByEmpId(Long userId);

public Employee saveEmp(Employee emp);

public Employee updateEmp(Employee emp);


}