package com.qa.persitence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persitence.domain.Owner;
import com.qa.persitence.domain.Recipe;
import com.qa.util.JSONUtil;


public class OwnerDBRepository implements OwnerRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createOwner(String owner) {
		Owner anOwner = util.getObjectForJSON(owner, Owner.class);
		manager.persist(anOwner);
		return "{\"message\": \"owner has been added\"}";
	}

	@Override
	
	public String getAllOwners() {
		Query query = manager.createQuery("Select a FROM Owner a");
		Collection<Owner> owners = (Collection<Owner>) query.getResultList();
		
		return util.getJSONForObject(owners);
	}

	@Override
	public String getAnOwner(Long owner_id) {
		return util.getJSONForObject(manager.find(Owner.class, owner_id));
	}

	@Override
	public String updateOwner(String recipe, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteOwner(Long owner_id) {
		Recipe ownerInDB = util.getObjectForJSON(getAnOwner(owner_id), Recipe.class);
		if (manager.contains(manager.find(Owner.class, owner_id))) {

			manager.remove(manager.find(Owner.class, owner_id));
		}
		return "{\"message\": \"owner sucessfully deleted\"}";
	}

	@Override
	public int cycleOwners(String name) {
		Query query = manager.createQuery("Select a from owner a");
		Collection<Owner> owners = (Collection<Owner>) query.getResultList();
		
		List<Owner> validList = owners.stream().filter(n -> n.getName().equals(name)).collect(Collectors.toList());
		return validList.size();
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	

}
