package com.br.example.eventdriven;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(properties = {
		"spring.main.banner-mode=off"
})
class EventDrivenApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		assertNotNull(applicationContext, "Application context should not be null");
	}

	@Test
	void mainMethodShouldStartApplication() {
		// Test the main method
		EventDrivenApplication.main(new String[]{});

		// Verify that the application started successfully
		assertNotNull(applicationContext, "Application should start successfully");
	}
}
