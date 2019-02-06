package com.qa.persitence.domain;

import javax.persistence.*;

@Entity
public class Owner {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long owner_id;
	private String name, skill;
	
	public Owner() {
		
	}

	public Owner(Long owner_id, String first_name,String skill) {
		this.owner_id = owner_id;
		this.setName(first_name);
		this.skill = skill;
	}

	public Long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
