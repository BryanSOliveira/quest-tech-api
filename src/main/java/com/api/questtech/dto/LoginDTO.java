package com.api.questtech.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	public LoginDTO() {
	}

	public LoginDTO(String username, String password) {
		this.username = username;
		this.password = password;
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
