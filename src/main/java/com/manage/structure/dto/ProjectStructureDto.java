package com.manage.structure.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectStructureDto {
	private String psid;
	private String name;
	private String description;
	private String parentid;
	private String type;
	private String othertype;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private List<RoleStructureDto> roleStructure;

	public ProjectStructureDto(String psid, String name, String description, String parentid, String type,
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

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public List<RoleStructureDto> getRoleStructure() {
		return roleStructure;
	}

	public void setRoleStructure(List<RoleStructureDto> roleStructure) {
		this.roleStructure = roleStructure;
	}

	public static class RoleStructureDto {
		private String rsid;
		private String parentid;
		private String role;
		private String reportingto;
		private LocalDateTime establishedon;
		private LocalDateTime updatedat;

		public RoleStructureDto() {
			super();
		}

		public RoleStructureDto(String rsid, String parentid, String role, String reportingto,
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
}
