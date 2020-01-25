package com.ntsebryk.timemate.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ntsebryk.timemate.domain.Task;
import com.ntsebryk.timemate.domain.User;

public interface TaskRepository extends MongoRepository<Task, String>{
	
	List<Task> findByUser(User user);
}
