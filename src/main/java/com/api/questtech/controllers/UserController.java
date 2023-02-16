package com.api.questtech.controllers;

import java.net.URI;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.questtech.dto.UserInDTO;
import com.api.questtech.dto.UserOutDTO;
import com.api.questtech.models.UserModel;
import com.api.questtech.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<Page<UserOutDTO>> findAll(Pageable pageable) {
		Page<UserModel> list = service.findAll(pageable);
		Page<UserOutDTO> usersOut = list.map(new Function<UserModel, UserOutDTO>() {
			@Override
			public UserOutDTO apply(UserModel user) {
				UserOutDTO dto = new UserOutDTO(user);
		        return dto;
			}
		});
		return ResponseEntity.ok().body(usersOut);
	}
	
	@PostMapping
	public ResponseEntity<UserOutDTO> insert(@RequestBody @Valid UserInDTO userIn) {
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(userIn, userModel);
		userModel = service.insert(userModel);
		UserOutDTO userOut = new UserOutDTO();
		BeanUtils.copyProperties(userModel, userOut);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userOut.getId()).toUri();
		return ResponseEntity.created(uri).body(userOut);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserOutDTO> update(@PathVariable Long id, @RequestBody UserInDTO userIn) {
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(userIn, userModel);
		userModel = service.update(id, userModel);
		UserOutDTO userOut = new UserOutDTO();
		BeanUtils.copyProperties(userModel, userOut);
		return ResponseEntity.ok().body(userOut);
	}
}
