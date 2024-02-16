package com.olimpus.service;

import java.util.Optional;

import com.olimpus.entity.Product;

public interface ProductService {

	Optional<Iterable<Product>> getProducts();

	Optional<Product> getProductById(Long id);

	Optional<Product> saveProduct(Product product);

	String deleteProduct(Product product);

}
