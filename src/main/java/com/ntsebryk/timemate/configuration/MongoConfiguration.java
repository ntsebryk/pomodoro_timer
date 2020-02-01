package com.ntsebryk.timemate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConfiguration {

	@Bean
	public MongoMappingContext mongoMappingContext() {
		MongoMappingContext mongoMappingContext = new MongoMappingContext();
		mongoMappingContext.setAutoIndexCreation(true);
		return mongoMappingContext;
	}
}
