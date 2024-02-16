package com.olimpus.repository;

import org.springframework.data.repository.CrudRepository;

import com.olimpus.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
