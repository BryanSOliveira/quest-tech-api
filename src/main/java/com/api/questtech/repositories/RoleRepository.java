package com.api.questtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.questtech.models.RoleModel;
import com.api.questtech.models.enums.RoleName;

public interface RoleRepository extends JpaRepository<RoleModel, Long>{

	RoleModel findByName(RoleName name);
}
