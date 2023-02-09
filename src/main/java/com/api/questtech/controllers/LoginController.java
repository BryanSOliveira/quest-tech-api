package com.api.questtech.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.questtech.dto.LoginDTO;
import com.api.questtech.dto.UserOutDTO;
import com.api.questtech.models.UserModel;
import com.api.questtech.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "login")
public class LoginController {
	
	@Autowired
	UserService service;

	@PostMapping
	public ResponseEntity<UserOutDTO> login(@RequestBody @Valid LoginDTO userIn) {
		UserModel userModel = service.login(userIn.getUsername(), userIn.getPassword());
		UserOutDTO userOut = new UserOutDTO();
		BeanUtils.copyProperties(userModel, userOut);
		return ResponseEntity.ok().body(userOut);
	}
}
