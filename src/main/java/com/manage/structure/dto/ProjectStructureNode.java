package com.manage.structure.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectStructureNode {
    private String id;
    private String name;
    private String description;
    private String type;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ProjectStructureNode> children;

    public ProjectStructureNode(String id, String name, String description, String type, String status, LocalDateTime createdAt,LocalDateTime updatedAt,  List<ProjectStructureNode> children) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.status = status;
        this.createdAt = createdAt;
        this.children = children;
        this.updatedAt = updatedAt;
    }

    public List<ProjectStructureNode> getChildren() {
        return children;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setChildren(List<ProjectStructureNode> children) {
		this.children = children;
	}

}

