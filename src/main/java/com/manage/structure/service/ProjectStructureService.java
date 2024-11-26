package com.manage.structure.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.structure.dto.ProjectStructureDto;
import com.manage.structure.dto.ProjectStructureDto.RoleStructureDto;
import com.manage.structure.dto.ProjectStructureNode;
import com.manage.structure.entity.ProjectStructure;
import com.manage.structure.entity.RoleStructure;
import com.manage.structure.repository.ProjectStructureRepository;
import com.manage.structure.repository.RoleStructureRepository;

@Service
public class ProjectStructureService {
	
	@Autowired
	private ProjectStructureRepository projectStructureRepo;
	
	@Autowired
	private RoleStructureRepository roleStructureRepo;
	
	public String createProjectStructure(ProjectStructureDto projectStructureDto) {
	    try {
	        ProjectStructure projectstructure = new ProjectStructure();
	        projectstructure.setPsid(UUID.randomUUID().toString());
	        
	        projectstructure.setName(projectStructureDto.getName());
	        projectstructure.setDescription(projectStructureDto.getDescription());
	        projectstructure.setParentid(projectStructureDto.getParentid());
	        projectstructure.setType(projectStructureDto.getType());
	        projectstructure.setOthertype(projectStructureDto.getOthertype());
	        projectstructure.setCreated_at(LocalDateTime.now());
	        
	        projectStructureRepo.save(projectstructure);
	        
	        return "Success";
	    } catch (Exception e) {
	        System.err.println(e.getMessage());
	        return e.getMessage();
	    }
	}
	
	public List<ProjectStructureNode> getAllProjectStructureBlock() {
	    List<ProjectStructure> projectStructureList = projectStructureRepo.findAll();
	    Map<String, ProjectStructureNode> projectMap = new HashMap<>();

	    for (ProjectStructure project : projectStructureList) {
	        projectMap.put(project.getPsid(), new ProjectStructureNode(
	                project.getPsid(),
	                project.getName(),
	                project.getDescription(),
	                project.getType(),
	                project.getOthertype(),
	                project.getCreated_at(),
	                project.getupdated_at(),
	                new ArrayList<>()
	        ));
	    }

	    List<ProjectStructureNode> rootProjects = new ArrayList<>();
	    for (ProjectStructure project : projectStructureList) {
	        ProjectStructureNode node = projectMap.get(project.getPsid());
	        
	        if (project.getParentid() != null) {
	            ProjectStructureNode parentNode = projectMap.get(project.getParentid());
	            if (parentNode != null) {
	                parentNode.getChildren().add(node); 
	            }
	        } else {
	            rootProjects.add(node);
	        }
	    }

	    return rootProjects;
	}

	 public ProjectStructureDto getProjectStructureDto(String psid) {
	        Optional<ProjectStructure> projectStructureOptional = projectStructureRepo.findById(psid);
	        if (projectStructureOptional.isPresent()) {
	            ProjectStructure projectStructure = projectStructureOptional.get();

	            ProjectStructureDto projectStructureDto = new ProjectStructureDto(
	                projectStructure.getPsid(),
	                projectStructure.getName(),
	                projectStructure.getDescription(),
	                projectStructure.getParentid(),
	                projectStructure.getType(),
	                projectStructure.getOthertype(),
	                projectStructure.getCreated_at(),
	                projectStructure.getupdated_at()
	            );

	            List<RoleStructure> roleStructures = roleStructureRepo.findByParentid(psid);
	            List<RoleStructureDto> roleStructureDtos = roleStructures.stream()
	                .map(role -> new RoleStructureDto(
	                    role.getRsid(),
	                    role.getParentid(),
	                    role.getRole(),
	                    role.getReportingto(),
	                    role.getEstablishedon(),
	                    role.getUpdatedat()
	                ))
	                .collect(Collectors.toList());

	            projectStructureDto.setRoleStructure(roleStructureDtos);
	            return projectStructureDto;
	        } else {
	            throw new IllegalArgumentException("Project structure with ID " + psid + " not found.");
	        }
	    }
}
