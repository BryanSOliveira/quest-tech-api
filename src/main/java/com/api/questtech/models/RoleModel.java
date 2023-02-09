package com.api.questtech.models;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

import com.api.questtech.models.enums.RoleName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_role")
public class RoleModel implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private RoleName name;
	
	public RoleModel() {
	}

	public RoleModel(Long id, RoleName name) {
		this.id = id;
		this.name = name;
	}

	public Long getRoleId() {
		return id;
	}

	public void setRoleId(Long id) {
		this.id = id;
	}

	public RoleName getRoleName() {
		return name;
	}

	public void setRoleName(RoleName name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return this.name.toString();
	}
}
