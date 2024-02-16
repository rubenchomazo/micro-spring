package com.olimpus.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HealthControlllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	// bind the above RANDOM_PORT
	@LocalServerPort
	private int port;

	@Test
	void getPing() throws Exception {
		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/health/v1/ping").toString(), String.class);
		assertEquals("pong", response.getBody());
	}

}
