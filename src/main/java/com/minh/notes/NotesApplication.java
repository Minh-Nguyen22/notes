package com.minh.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

}
