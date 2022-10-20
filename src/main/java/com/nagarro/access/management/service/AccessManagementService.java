package com.nagarro.access.management.service;

public interface AccessManagementService {

	public boolean isValidAccess(Long accessId);

	public void recordPunchTime(Long accessId, boolean isPunchIn);
}
