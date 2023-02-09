package com.api.questtech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.questtech.models.UserModel;
import com.api.questtech.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public List<UserModel> findAll() {
		return repository.findAll();
	}
	
	@Transactional
	public UserModel insert(UserModel user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public UserModel update(Long id, UserModel user) {
		UserModel userModel = repository.getReferenceById(id);
		updateData(userModel, user);
		return repository.save(userModel);
	}
	
	private void updateData(UserModel userModel, UserModel user) {
		userModel.setPassword(passwordEncoder.encode(user.getPassword()));
	}
	
	public UserModel login(String username, String password) {
		UserModel user = repository.findByUsername(username)
						 .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return passwordEncoder.matches(password, user.getPassword()) ? user : null;
	}
}
