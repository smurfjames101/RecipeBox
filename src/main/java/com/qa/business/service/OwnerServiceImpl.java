package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persitence.repository.OwnerRepository;

public class OwnerServiceImpl implements OwnerService{
	@Inject
	private OwnerRepository repo;
	
	
	@Override
	public String createOwner(String owner) {
		if(owner.contains("bert"))
		{
			return "Can't add owner";	
		}
		
		if(owner.contains("Josh"))
		{
			return "Can't add owner";
		}
		return repo.createOwner(owner);
		
	}

	@Override
	public String getAllOwners() {
		return repo.getAllOwners();
	}


	@Override
	public String getAnOwner(Long owner_id) {
		return repo.getAnOwner(owner_id);
	}


	@Override
	public String updateOwner(String owner,Long owner_id) {
		return repo.updateOwner(owner, owner_id);
	}


	@Override
	public String deleteOwner(Long owner_id) {
		return repo.deleteOwner(owner_id);
	}


	@Override
	public int cycleOwners(String name) {
		return repo.cycleOwners(name);
	}

	
}
