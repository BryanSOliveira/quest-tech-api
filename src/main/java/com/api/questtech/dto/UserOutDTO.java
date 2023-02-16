package com.api.questtech.dto;

import java.io.Serializable;
import java.util.Set;

import com.api.questtech.models.PlayerModel;
import com.api.questtech.models.RoleModel;
import com.api.questtech.models.UserModel;

public class UserOutDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String username;
	private PlayerModel player;
	private Set<RoleModel> roles;
	
	public UserOutDTO() {
	}

	public UserOutDTO(Long id, String name, String email, String username, String password, Set<RoleModel> roles, PlayerModel player) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.player = player;
		this.roles = roles;
	}

	public UserOutDTO(UserModel userModel) {
		this.id = userModel.getId();
		this.name = userModel.getName();
		this.email = userModel.getEmail();
		this.username = userModel.getUsername();
		this.player = userModel.getPlayer();
		this.roles = userModel.getRoles();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public PlayerModel getPlayer() {
		return player;
	}

	public void setPlayer(PlayerModel player) {
		this.player = player;
	}

	public Set<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}
}
