package com.ntsebryk.timemate.service;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntsebryk.timemate.domain.PomodoroItem;
import com.ntsebryk.timemate.domain.Task;
import com.ntsebryk.timemate.repository.TaskRepository;

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
}
