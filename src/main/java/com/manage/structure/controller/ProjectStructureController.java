package com.manage.structure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manage.structure.dto.ProjectStructureDto;
import com.manage.structure.dto.ProjectStructureNode;
import com.manage.structure.entity.ProjectStructure;
import com.manage.structure.service.ProjectStructureService;

@RestController
@RequestMapping("/projectStructure")
public class ProjectStructureController {
	
	@Autowired 
	private ProjectStructureService projectStructureService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createProjectStructure(@RequestBody ProjectStructureDto projectStructureDto)
	{
		try {
			String response = projectStructureService.createProjectStructure(projectStructureDto);
		    return ResponseEntity.ok(response);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error occurred while creating the Structure: " + e.getMessage());
		}
	}
	
	@GetMapping("allProjectStructureBlocks")
	public ResponseEntity<?> getAllProjectStructureBlocks()
	{
		try {
			List<ProjectStructureNode> projectStructureList = projectStructureService.getAllProjectStructureBlock();
			
			return ResponseEntity.ok(projectStructureList);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error occurred while fetching the Structure: " + e.getMessage());
		}
	}
	
	@GetMapping("/projectStructure")
    public ResponseEntity<?> getProjectStructure(@RequestParam String psid) {
        try {
            ProjectStructureDto projectStructureDto = projectStructureService.getProjectStructureDto(psid);
            return ResponseEntity.ok(projectStructureDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error occurred while fetching the Project Structure: " + e.getMessage());
        }
    } 
	
}
