package com.productService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productService.model.Product;
import com.productService.service.ProductService;

@RestController
@RequestMapping("/api")
class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public List<Product> getProduct(@RequestParam Product product) {
		return productService.getAllProducts(product);
	}

	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@Valid @RequestBody Product product) {
		productService.createProduct(product);
		return ResponseEntity.ok().body("Product is created successfully");
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
		productService.updateProduct(product);
		return ResponseEntity.ok().body("Product is updated successfully");
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		productService.deleteProductbyId(id);
		return ResponseEntity.ok().body("Product is Deleted successfully");
	}
}