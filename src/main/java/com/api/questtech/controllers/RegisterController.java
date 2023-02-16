package com.api.questtech.controllers;

import java.net.URI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.questtech.dto.UserInDTO;
import com.api.questtech.dto.UserOutDTO;
import com.api.questtech.models.UserModel;
import com.api.questtech.services.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {
	
	@Autowired
	AccountService service;

	@PostMapping
	public ResponseEntity<UserOutDTO> insert(@RequestBody @Valid UserInDTO userIn) {
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(userIn, userModel);
		userModel = service.register(userModel);
		UserOutDTO userOut = new UserOutDTO();
		BeanUtils.copyProperties(userModel, userOut);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userOut.getId()).toUri();
		return ResponseEntity.created(uri).body(userOut);
	}
}
