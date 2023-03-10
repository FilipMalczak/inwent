package com.github.filipmalczak.inwent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class InwentApplication {
	//todo take care of http caching, most of the stuff is write-once, read-only

	public static void main(String[] args) {
		run(args);
	}

	public static ConfigurableApplicationContext run(String... args){
		return SpringApplication.run(InwentApplication.class, args);
	}
}
