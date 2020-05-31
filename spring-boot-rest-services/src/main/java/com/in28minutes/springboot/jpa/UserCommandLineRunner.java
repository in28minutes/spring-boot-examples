package com.in28minutes.springboot.jpa;

import com.in28minutes.springboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
@Order(2)
public class UserCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory
			.getLogger(UserCommandLineRunner.class);


	private UserRepository repository;

	@Autowired
	UserCommandLineRunner(UserRepository userRepository)
	{
		repository=userRepository;
	}

	@Override
	@Transactional
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
