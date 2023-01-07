package com.github.filipmalczak.inwent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InwentApplication {
	//todo take care of http caching, most of the stuff is write-once, read-only

	public static void main(String[] args) {
		SpringApplication.run(InwentApplication.class, args);
	}

}
