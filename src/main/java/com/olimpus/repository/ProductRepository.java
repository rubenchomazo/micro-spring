package com.olimpus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.olimpus.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
