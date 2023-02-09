package com.api.questtech.dto;

import java.io.Serializable;

import com.api.questtech.models.UserModel;

import jakarta.validation.constraints.NotBlank;

public class UserInDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	public UserInDTO() {
	}

	public UserInDTO(Long id, String name, String email, String username, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public UserInDTO(UserModel userModel) {
		this.id = userModel.getId();
		this.name = userModel.getName();
		this.email = userModel.getEmail();
		this.username = userModel.getUsername();
		this.password = userModel.getPassword();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
