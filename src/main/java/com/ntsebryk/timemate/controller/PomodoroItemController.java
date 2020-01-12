package com.ntsebryk.timemate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ntsebryk.timemate.domain.PomodoroItem;
import com.ntsebryk.timemate.repository.PomodoroItemRepository;

@RestController
@RequestMapping("/api/work-items")
public class PomodoroItemController {
	
	@Autowired
	PomodoroItemRepository pomodoroRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void savePomodoroItem(@Valid @RequestBody PomodoroItem pItem) {
		pomodoroRepository.insert(pItem);
	}
	
	@GetMapping
	public List<PomodoroItem> getPomodoroItems() {
		return pomodoroRepository.findAll();
	}

}
