package com.nagarro.access.management.bean;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Visitor extends Member{
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column(insertable = false, updatable = false)
private long visitorId;	
private String visitorType;
private String contactPerson;

}
