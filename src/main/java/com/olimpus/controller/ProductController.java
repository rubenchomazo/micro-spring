package com.olimpus.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olimpus.entity.Product;
import com.olimpus.service.impl.ProductServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/product/")
@AllArgsConstructor
public class ProductController {

	private final ProductServiceImpl productServiceImpl;

	@GetMapping(path = "/get-all")
	private Optional<Iterable<Product>> getAllProducts() {
		return productServiceImpl.getProducts();
	}

	@PostMapping(path = "/save")
	private Optional<Product> saveProduct(@RequestBody Product product) {
		return productServiceImpl.saveProduct(product);
	}

	@PutMapping(path = "/update")
	private Optional<Product> udpateProduct(@RequestBody Product product) {
		return productServiceImpl.saveProduct(product);
	}

	@DeleteMapping(path = "/delete")
	private String deleteProduct(@RequestBody Product product) {
		return productServiceImpl.deleteProduct(product);
	}

}
