package com.manage.structure.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.structure.entity.RoleStructure;
import com.manage.structure.repository.RoleStructureRepository;

@Service
public class RoleStructureService {

	@Autowired
	private RoleStructureRepository roleStructureRepo;
	
	public RoleStructure createRoleRelation(RoleStructure roleStructure)
	{
		try {
			roleStructure.setEstablishedon(LocalDateTime.now());
			return roleStructureRepo.save(roleStructure);
		}
		catch(Exception e)
		{
			return null;
		}
		
	}
	
	public Optional<RoleStructure> getRoleRelation(String rsid)
	{
		return roleStructureRepo.findById(rsid);
	}
	
	public RoleStructure updateRoleRelation(String rsid, RoleStructure updatedRoleStructure) {
		return roleStructureRepo.findById(rsid).map(existingRoleStructure -> {
			existingRoleStructure.setParentid(updatedRoleStructure.getParentid());
			existingRoleStructure.setRole(updatedRoleStructure.getRole());
			existingRoleStructure.setReportingto(updatedRoleStructure.getReportingto());
			existingRoleStructure.setUpdatedat(LocalDateTime.now());
			return roleStructureRepo.save(existingRoleStructure);
		}).orElse(null);
	}
	
	public boolean deleteRoleRelation(String rsid) {
		if (roleStructureRepo.existsById(rsid)) {
			roleStructureRepo.deleteById(rsid);
			return true;
		}
		return false;
	}
}
