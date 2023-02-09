package com.api.questtech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.questtech.models.RoleModel;
import com.api.questtech.models.UserModel;
import com.api.questtech.models.enums.RoleName;
import com.api.questtech.repositories.RoleRepository;
import com.api.questtech.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestInstantiation implements CommandLineRunner {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		RoleModel role1 = new RoleModel(null, RoleName.USER);
		roleRepository.save(role1);
		
		UserModel user1 = new UserModel(null, "Bryan Santos", "sp.bryansantos@gmail.com", "Bryan", passwordEncoder.encode("123"));
		user1.getRoles().add(role1);
		userRepository.save(user1);
	}

}
