package com.qa.business.service;

public interface OwnerService {

	String createOwner(String owner);
	
	String getAllOwners();
	String getAnOwner(Long owner_id);
	
	String updateOwner(String owner,Long owner_id);
	
	String deleteOwner(Long owner_id);
	
	int cycleOwners(String name);
}
