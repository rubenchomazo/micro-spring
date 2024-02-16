package com.olimpus.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.olimpus.entity.Product;
import com.olimpus.repository.ProductRepository;
import com.olimpus.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public Optional<Iterable<Product>> getProducts() {
		return Optional.of(productRepository.findAll());
	}

	@Override
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Optional<Product> saveProduct(Product product) {
		productRepository.save(product);
		return Optional.of(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

}
