package com.ntsebryk.timemate.domain;

import java.util.Collection;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@Document(collection="tasks")
@TypeAlias("task")

public class Task {
	@Id
	String id;
	@NotBlank
	String itemName;
	@JsonIgnore
	@DBRef
	User user;
	@UniqueElements
	Collection<PomodoroItem> items;
}
