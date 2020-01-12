package com.ntsebryk.timemate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ntsebryk.timemate.domain.Task;

public interface TaskRepository extends MongoRepository<Task, String>{

}
