package com.productService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productService.model.Product;

@Service
public interface ProductService {
	
	public void deleteProductbyId(int id);

	public void updateProduct(Product prod);

	public void deleteAllProducts();

	Optional<Product> findProductById(int id);

	void createProduct(Product product);

	List<Product> getAllProducts(Product product);

}
