package com.olimpus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Health", description = "Validate the API health")
@RestController
@RequestMapping(path = "/health/v1")
public class HealthControlller {

	@GetMapping(path = "ping")
	@Operation(summary = "Fetch the ping", description = "fetche the ping for validate the API health ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation"),
			@ApiResponse(responseCode = "404", description = "Health not found") })
	ResponseEntity<String> ping() {
		return ResponseEntity.ok("pong");
	}

}
