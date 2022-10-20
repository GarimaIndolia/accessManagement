package com.nagarro.access.management.bean;

import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Column;
import javax.persistence.Inheritance;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
public class Member {
@Column( updatable = false)
private String name;
private String currentLoc;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCurrentLoc() {
	return currentLoc;
}
public void setCurrentLoc(String currentLoc) {
	this.currentLoc = currentLoc;
}

}
