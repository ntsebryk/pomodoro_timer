package com.ntsebryk.timemate.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ntsebryk.timemate.domain.PomodoroItem;
import com.ntsebryk.timemate.domain.Task;
import com.ntsebryk.timemate.domain.User;
import com.ntsebryk.timemate.repository.TaskRepository;
import com.ntsebryk.timemate.repository.UserRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	public void createTask(Task task) {
		Collection<PomodoroItem> items = task.getItems();
		
		LocalDateTime lDateTime = LocalDateTime.now();
		long duration = 0L;
		
		for (PomodoroItem pomodoroItem : items) {
			duration += pomodoroItem.getDuration();
			pomodoroItem.setStartTime(lDateTime.minusMinutes(duration));
		}
		
		taskRepository.insert(task);
	}

	
	public void addItemToTask(String taskId, PomodoroItem item) {
		//add validation of startTime, prohibit startTime that intersect other item
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("Resourse with id %s not found", taskId)));
		item.setStartTime(LocalDateTime.now().minusMinutes(item.getDuration()));
		task.getItems().add(item);
		taskRepository.save(task);
	}
	
}
