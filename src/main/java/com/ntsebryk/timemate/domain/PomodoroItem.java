package com.ntsebryk.timemate.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PomodoroItem {
	@Id
	Long id;
	Long userId;
	LocalDateTime starTime;
}
