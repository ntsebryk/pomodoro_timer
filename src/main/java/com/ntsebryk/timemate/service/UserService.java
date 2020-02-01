package com.ntsebryk.timemate.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ntsebryk.timemate.domain.User;
import com.ntsebryk.timemate.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (Objects.isNull(user)) {
			return null;
		}
		return user;
	}
	
	
	public User createUser(User user) {
		user.setPassword(passEncoder.encode(user.getPassword()));
		return userRepository.insert(user);
	}
	
	public User updateUser(User user) {
		Example<User> userExample = Example.of(user);
		User dbUser = userRepository.findOne(userExample)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Resourse with id %s not found", user.getId())));
		
		dbUser.setPassword(passEncoder.encode(user.getPassword()));
		dbUser.setUsername(user.getUsername());
		dbUser.setRoles(user.getRoles());
		
		return userRepository.save(dbUser);
	}
}
