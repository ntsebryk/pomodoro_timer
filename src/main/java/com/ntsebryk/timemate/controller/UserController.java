package com.ntsebryk.timemate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ntsebryk.timemate.domain.User;
import com.ntsebryk.timemate.repository.UserRepository;
import com.ntsebryk.timemate.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@Valid @RequestBody User user) {
		userService.createUser(user);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateUser(@Valid @RequestBody User user) {
		userService.updateUser(user);
	}
	
	@GetMapping
	public List<User> getUsers() {
		return userRepository.findAll();
	}

}
