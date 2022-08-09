package com.maria.users.management.system;

import com.maria.users.management.system.model.User;
import com.maria.users.management.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	@Autowired private UserRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
