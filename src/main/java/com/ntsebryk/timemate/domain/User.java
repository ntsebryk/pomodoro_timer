package com.ntsebryk.timemate.domain;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class User {
	@Id
	String id;
	@NotBlank
	@Indexed(unique=true)
	String username;
	String password;
	String roles;
}
