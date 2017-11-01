package com.spectrum.usergroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsergroupApplication implements CommandLineRunner {

	@Autowired
	private UserGroupRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UsergroupApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple
		repository.save(new UserGroup("wonders", "today", "active"));
		repository.save(new UserGroup("sleeping", "today", "inactive"));

		// fetch all customers
		System.out.println("groups found with findAll():");
		System.out.println("-------------------------------");
		for (UserGroup group : repository.findAll()) {
			System.out.println(group);
		}
		System.out.println();

		// fetch an individual
		System.out.println("Group found with findByName('wonders'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByName("wonders"));


	}

}
