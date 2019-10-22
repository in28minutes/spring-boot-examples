package com.in28minutes.springboot.jpa;

import com.in28minutes.springboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserCommandLineRunner implements CommandLineRunner {

	private UserRepository repository;

	@Autowired
	public UserCommandLineRunner(UserRepository repository){
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {

		repository.save(new User("Ranga", "Admin"));
		repository.save(new User("Ravi", "User"));
		repository.save(new User("Satish", "Admin"));
		repository.save(new User("Raghu", "User"));

		for (User user : repository.findAll()) {
			log.info(user.toString());
		}

		log.info("Admin users are.....");
		log.info("____________________");
		for (User user : repository.findByRole("Admin")) {
			log.info(user.toString());
		}

	}

}
