package com.olimpus.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.olimpus.entity.Product;
import com.olimpus.service.impl.ProductServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/product/")
@Tag(name = "Products", description = "Products Api")
@AllArgsConstructor
public class ProductController {

	private final ProductServiceImpl productServiceImpl;

	@GetMapping(path = "/get-all")
	@Operation(summary = "Fetch all products", description = "fetches all plant entities and their data from data source")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	ResponseEntity<Optional<Iterable<Product>>> getAllProducts() {
		return ResponseEntity.ok(productServiceImpl.getProducts());
	}

	@GetMapping(path = "/get-by-id")
	@Operation(summary = "Get Product by Id", description = "Get Product by Id from database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Ok", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
			@ApiResponse(responseCode = "404", description = "Product not found") })
	ResponseEntity<Optional<Product>> getById(@RequestParam Long productId) {
		return ResponseEntity.ok(productServiceImpl.getProductById(productId));
	}

	@PostMapping(path = "/save")
	@Operation(summary = "Save and update product", description = "Save and update product into database")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	ResponseEntity<Optional<Product>> saveProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productServiceImpl.saveProduct(product));
	}

	@DeleteMapping(path = "/delete")
	@Operation(summary = "delete product", description = "delete product into database")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	ResponseEntity<?> deleteProduct(@RequestBody Product product) {
		productServiceImpl.deleteProduct(product);
		return ResponseEntity.ok().build();
	}

}
