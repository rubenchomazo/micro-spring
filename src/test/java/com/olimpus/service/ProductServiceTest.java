package com.olimpus.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.olimpus.entity.Product;
import com.olimpus.repository.ProductRepository;
import com.olimpus.service.impl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks // auto inject helloRepository
	private ProductServiceImpl productService;

	@DisplayName("Save - Test Mock productService + productRepository")
	@Test
	void testSave() {
		Product newProduct = new Product(999l, "ProductTest1", "TestDec", 25.0);
		when(productRepository.save(newProduct)).thenReturn(newProduct);
		assertEquals("ProductTest1", productService.saveProduct(newProduct).get().getName());
	}

	@DisplayName("Delete - Test Mock productService + productRepository")
	@Test
	void testDelete() {
		Product newProduct = new Product(999l, "ProductTest1", "TestDec", 25.0);
		when(productRepository.save(newProduct)).thenReturn(newProduct);
		productRepository.deleteById(newProduct.getId());
		assertEquals(0, productRepository.count());

	}

	@DisplayName("Get By Id - Test Mock productService + productRepository")
	@Test
	void testGetById() {
		Product newProduct = new Product(999l, "ProductTest1", "TestDec", 25.0);
		when(productRepository.findById(999l)).thenReturn(Optional.of(newProduct));
		Optional<Product> returnedProduct = productService.getProductById(999l);
		assertTrue(returnedProduct.isPresent());
	}

	@DisplayName("Query All - Test Mock productService + productRepository")
	@Test
	void testGetAll() {
		Product newProduct = new Product(999l, "ProductTest1", "TestDec", 25.0);
		when(productRepository.findAll()).thenReturn(List.of(newProduct));
		List<Product> productList = (List<Product>) this.productService.getProducts().get();
		assertEquals(List.of(newProduct), productList);
	}

}
