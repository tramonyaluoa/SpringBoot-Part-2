package com.SpringPart2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringPart2Application {

	public static void main(String[] args) {
		SpringApplication.run (SpringPart2Application.class, args); // start spring application
		UserServiceImpl user = new UserServiceImpl ( );  // implementing the UserServiceImpl class as user

		//Print the Users functionality from the UserServiceImpl class
		System.out.println (user.addUser (1, "Neil", "Armstrong"));
		System.out.println (user.getUser (1));

System.out.println ( "" );
		System.out.println (user.addUser (2, "Teboho", "Ramonyaluoa"));
		System.out.println (user.getUser (2));

	}}
