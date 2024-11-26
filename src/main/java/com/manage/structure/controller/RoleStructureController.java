package com.manage.structure.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manage.structure.entity.RoleStructure;
import com.manage.structure.service.RoleStructureService;

@RestController
@RequestMapping("/roleRelationship")
public class RoleStructureController {
	
	@Autowired
	private RoleStructureService roleStructureService;
	
	 @PostMapping("/create")
	    public ResponseEntity<RoleStructure> createRoleRelationshipStructure(@RequestBody RoleStructure roleStructure) {
	        RoleStructure createdRoleStructure = roleStructureService.createRoleRelation(roleStructure);
	        return new ResponseEntity<>(createdRoleStructure, HttpStatus.CREATED);
	    }
	 
	 @GetMapping("/getRolerelationship")
	 public ResponseEntity<?> getRoleRelationship(@RequestParam String rsid)
	 {
		 Optional<RoleStructure> value = roleStructureService.getRoleRelation(rsid);
		 return ResponseEntity.ok(value);
	 }
	 
	 @PutMapping("/edit")
		public ResponseEntity<?> editRoleRelationship(@RequestParam String rsid, @RequestBody RoleStructure updatedRoleStructure) {
			RoleStructure updatedRole = roleStructureService.updateRoleRelation(rsid, updatedRoleStructure);
			if (updatedRole != null) {
				return ResponseEntity.ok(updatedRole);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RoleStructure not found");
			}
		}
		
		@DeleteMapping("/delete")
		public ResponseEntity<String> deleteRoleRelationship(@RequestParam String rsid) {
			boolean isDeleted = roleStructureService.deleteRoleRelation(rsid);
			if (isDeleted) {
				return ResponseEntity.ok("RoleStructure deleted successfully");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RoleStructure not found");
			}
		}
}
