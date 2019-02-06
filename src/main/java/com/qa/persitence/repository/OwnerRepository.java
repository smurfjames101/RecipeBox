package com.qa.persitence.repository;

public interface OwnerRepository {
	//C
	String createOwner(String recipe);
	//R
	String getAllOwners();
	String getAnOwner(Long id);
	//U
	String updateOwner(String owner, Long id);
	//D
	String deleteOwner(Long id);
	
	int cycleOwners(String name);
}
