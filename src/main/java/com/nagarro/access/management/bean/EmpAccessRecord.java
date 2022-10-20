package com.nagarro.access.management.bean;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class EmpAccessRecord {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empAccessRecordId;
	private LocalDateTime timeIn;
	private LocalDateTime timeOut;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "empId", nullable = false)
	private Employee empId;
	
	private String reason;
	private String updatedBy;
	
}
