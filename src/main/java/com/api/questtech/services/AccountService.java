package com.api.questtech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.questtech.models.PlayerModel;
import com.api.questtech.models.RoleModel;
import com.api.questtech.models.UserModel;
import com.api.questtech.models.enums.RoleName;
import com.api.questtech.repositories.RoleRepository;
import com.api.questtech.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	RoleRepository repositoryRole;
	
	final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserModel login(String username, String password) {
		UserModel user = repository.findByUsername(username)
						 .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return passwordEncoder.matches(password, user.getPassword()) ? user : null;
	}
	
	@Transactional
	public UserModel register(UserModel user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		RoleModel role = repositoryRole.findByName(RoleName.USER);
		user.getRoles().add(role);
		PlayerModel playerModel = new PlayerModel(null, user, 1, 0);
		user.setPlayer(playerModel);
		user = repository.save(user);
		return user;
	}
}
