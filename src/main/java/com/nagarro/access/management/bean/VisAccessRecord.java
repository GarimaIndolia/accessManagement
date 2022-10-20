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
public class VisAccessRecord {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long visAccessRecordId;
	private LocalDateTime timeIn;
	private LocalDateTime timeOut;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "visitorId", nullable = false)
	private Visitor visitorId;
	
	private String reason;
	private String updatedBy;
}
