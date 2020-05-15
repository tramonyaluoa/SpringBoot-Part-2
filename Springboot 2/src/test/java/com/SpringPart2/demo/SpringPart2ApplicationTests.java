package com.SpringPart2.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = SpringPart2Application.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Http Request Test

public class SpringPart2ApplicationTests {
	UserServiceImpl userServiceIml=new UserServiceImpl();

	private URL base;
	@Autowired
	private TestRestTemplate template ;


	@LocalServerPort      //annotation to inject the port that got allocated at runtime
	private int port;
	@BeforeEach        //method should be executed before each @Test method in the current class.
	public void urlLink()throws Exception{
		this.base=new URL ("http://localhost:"+port); //allocate the injected port to the URL base http://localhost:
	}

	@Test
	void addUser(){
		userServiceIml.addUser(1,"Neil","Armstrong");
		assertEquals("Neil Armstrong Was Successfully Entered",userServiceIml.addUser(1,"Neil","Armstrong"));
	}

	@Test
	void removeUser(){
		userServiceIml.addUser(1,"Neil","Armstrong");
		assertEquals("Neil Armstrong Was Successfully Removed",userServiceIml.removeUser (1));
	}

	@Test
	void getUser(){
		userServiceIml.addUser(1,"Neil","Armstrong");
		assertEquals("Hello Neil",userServiceIml.getUser(1));
	}
	@Test
	@Cacheable("User")
	void getUserFourTimes() {
		userServiceIml.addUser(1,"Neil","Armstrong");
		for (int i = 0; i < 4; i++) {                         //Get user 4 times
			 userServiceIml.getUser (1);
		}
	}

	@Test
	void WebConfigTest() throws Exception{                 //Testing Credentials for security
		ResponseEntity<String> response = template
				.withBasicAuth("tramonyaluoa","wordspass213")
				.getForEntity(base.toString(),
				String.class);
	}

}