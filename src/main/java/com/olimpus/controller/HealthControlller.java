package com.olimpus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Health", description = "Validate the API")
@RestController
@RequestMapping(path = "/health/v1")
public class HealthControlller {

	@GetMapping(path = "ping")
	String ping() {
		return "pong";
	}

}
