package com.api.questtech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.questtech.models.RoleModel;
import com.api.questtech.models.UserModel;
import com.api.questtech.models.enums.RoleName;
import com.api.questtech.repositories.RoleRepository;
import com.api.questtech.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	RoleRepository repositoryRole;
	
	final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public Page<UserModel> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@Transactional
	public UserModel insert(UserModel user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		RoleModel role = repositoryRole.findByName(RoleName.USER);
		user.getRoles().add(role);
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
		if(user.getPassword() != null) {
		  userModel.setPassword(passwordEncoder.encode(user.getPassword()));
		} 
		
		if(user.getName() != null) {
			userModel.setName(user.getName());
		}
	}
}
