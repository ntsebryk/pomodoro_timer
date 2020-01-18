package com.ntsebryk.timemate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ntsebryk.timemate.domain.User;
import com.ntsebryk.timemate.repository.UserRepository;

@Component
public class DbInitializer implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passEncoder;

	@Override
	public void run(String... args) throws Exception {
		User adminUser = new User();
		adminUser.setUsername("admin");
		adminUser.setPassword(passEncoder.encode("123456"));
		adminUser.setRoles("ADMIN");
		
		if (userRepository.findByUsername(adminUser.getUsername()) == null) {
			userRepository.insert(adminUser);
		}
	}

}
