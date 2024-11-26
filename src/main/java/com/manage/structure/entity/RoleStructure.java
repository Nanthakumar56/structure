package com.manage.structure.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="rolestructure")
public class RoleStructure {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private String rsid;
	private String parentid;
	private String role;
	private String reportingto;	
	private LocalDateTime establishedon;
	private LocalDateTime updatedat;
	
	public RoleStructure() {
		super();
	}

	public RoleStructure(String rsid, String parentid, String role, String reportingto,
			LocalDateTime establishedon, LocalDateTime updatedat) {
		super();
		this.rsid = rsid;
		this.parentid = parentid;
		this.role = role;
		this.reportingto = reportingto;
		this.establishedon = establishedon;
		this.updatedat = updatedat;
	}

	public String getRsid() {
		return rsid;
	}

	public void setRsid(String rsid) {
		this.rsid = rsid;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getReportingto() {
		return reportingto;
	}

	public void setReportingto(String reportingto) {
		this.reportingto = reportingto;
	}

	public LocalDateTime getEstablishedon() {
		return establishedon;
	}

	public void setEstablishedon(LocalDateTime establishedon) {
		this.establishedon = establishedon;
	}

	public LocalDateTime getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(LocalDateTime updatedat) {
		this.updatedat = updatedat;
	}

}
