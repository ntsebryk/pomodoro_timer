package com.ntsebryk.timemate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ntsebryk.timemate.domain.PomodoroItem;
import com.ntsebryk.timemate.service.TaskService;

@RestController
@RequestMapping("/api/tasks/")
public class PomodoroItemController {
	
	@Autowired
	TaskService taskService;

	@PostMapping(value = "/{id}/items")
	@ResponseStatus(HttpStatus.CREATED)
	public void addPomodoroItem(@PathVariable String id, @Valid @RequestBody PomodoroItem pItem) {
		taskService.addItemToTask(id, pItem);
	}
}
