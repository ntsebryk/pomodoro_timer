package com.ntsebryk.timemate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ntsebryk.timemate.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	User findByUsername(String username);

}
