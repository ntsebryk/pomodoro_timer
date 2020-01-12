package com.ntsebryk.timemate.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;
import org.springframework.stereotype.Component;

import com.ntsebryk.timemate.domain.Task;

//@Component
public class TaskBeforeSaveCallback implements BeforeConvertCallback<Task>{

	@Override
	public Task onBeforeConvert(Task entity, String collection) {
		/*
		 * if (entity.getItems() != null) { entity.getItems().forEach(i -> i.setId(new
		 * ObjectId().toHexString())); }
		 */
		return entity;
	}
}
