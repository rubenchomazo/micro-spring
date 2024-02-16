package com.olimpus.service;

import java.util.Optional;

import com.olimpus.entity.Product;

public interface ProductService {

	/**
	 * Get All products
	 * 
	 * @return Optional<Iterable<Product>>
	 */
	Optional<Iterable<Product>> getProducts();

	/**
	 * Get Product by Id
	 * 
	 * @param id
	 * @return Optional<Product>
	 */
	Optional<Product> getProductById(Long id);

	/**
	 * Save Product into data base
	 * 
	 * @param Product
	 * @return
	 */
	Optional<Product> saveProduct(Product product);

	/**
	 * Delete product
	 * 
	 * @param product
	 */
	void deleteProduct(Product product);

}
