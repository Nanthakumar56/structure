package com.manage.structure.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="projectstructure")
public class ProjectStructure {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private String psid;
	private String name;
	private String description;
	private String parentid;
	private String type;
	private String othertype;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	public ProjectStructure() {
		super();
	}

	public ProjectStructure(String psid, String name, String description, String parentid, String type,
			String othertype, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.psid = psid;
		this.name = name;
		this.description = description;
		this.parentid = parentid;
		this.type = type;
		this.othertype = othertype;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public String getPsid() {
		return psid;
	}

	public void setPsid(String psid) {
		this.psid = psid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOthertype() {
		return othertype;
	}

	public void setOthertype(String othertype) {
		this.othertype = othertype;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getupdated_at() {
		return updated_at;
	}

	public void setupdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
}
