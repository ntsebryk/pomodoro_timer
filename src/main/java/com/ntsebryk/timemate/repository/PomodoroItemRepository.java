	package com.ntsebryk.timemate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ntsebryk.timemate.domain.PomodoroItem;

public interface PomodoroItemRepository extends MongoRepository<PomodoroItem, Long>{

}
