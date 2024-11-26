package com.manage.structure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.structure.entity.RoleStructure;

@Repository
public interface RoleStructureRepository extends JpaRepository<RoleStructure, String> {
    List<RoleStructure> findByParentid(String parentid);

}
