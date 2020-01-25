package com.ntsebryk.timemate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ntsebryk.timemate.domain.Task;
import com.ntsebryk.timemate.domain.User;
import com.ntsebryk.timemate.repository.TaskRepository;
import com.ntsebryk.timemate.repository.UserRepository;
import com.ntsebryk.timemate.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	Authentication authentication;


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addTask(@Valid @RequestBody Task task, @AuthenticationPrincipal User currentUser) {
		task.setUser(currentUser);
		taskService.createTask(task);
	}

	@GetMapping
	public List<Task> getTasks(@AuthenticationPrincipal User currentUser) {
		return taskRepository.findByUser(currentUser);
	}

	@GetMapping(value = "/{id}")
	public Task getTaskById(@PathVariable String id) {
		return taskRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("Resourse with id %s not found", id)));
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteTaskById(@PathVariable String id) {
		 taskRepository.deleteById(id);
	}

}
