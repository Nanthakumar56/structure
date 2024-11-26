package com.manage.structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.structure.entity.ProjectStructure;

@Repository
public interface ProjectStructureRepository extends JpaRepository<ProjectStructure, String> 
{
	
}
