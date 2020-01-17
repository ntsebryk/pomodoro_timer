package com.ntsebryk.timemate.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	String id;
	String username;
	String password;
}
