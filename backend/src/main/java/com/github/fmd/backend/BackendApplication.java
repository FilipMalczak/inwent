package com.github.fmd.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
	//todo take care of http caching, most of the stuff is write-once, read-only

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
