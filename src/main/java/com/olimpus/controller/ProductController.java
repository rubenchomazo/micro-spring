package com.olimpus.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olimpus.entity.Product;
import com.olimpus.service.impl.ProductServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/product/")
@AllArgsConstructor
public class ProductController {

	private final ProductServiceImpl productServiceImpl;

	@GetMapping(path = "/get-all")
	@Operation(summary = "Fetch all products", description = "fetches all plant entities and their data from data source")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	private ResponseEntity<Optional<Iterable<Product>>> getAllProducts() {
		return ResponseEntity.ok(productServiceImpl.getProducts());
	}

	@PostMapping(path = "/save")
	private ResponseEntity<Optional<Product>> saveProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productServiceImpl.saveProduct(product));
	}

	@PutMapping(path = "/update")
	private Optional<Product> udpateProduct(@RequestBody Product product) {
		return productServiceImpl.saveProduct(product);
	}

	@DeleteMapping(path = "/delete")
	private BodyBuilder deleteProduct(@RequestBody Product product) {
		productServiceImpl.deleteProduct(product);
		return ResponseEntity.ok();
	}

}
