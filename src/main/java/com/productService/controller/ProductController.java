package com.productService.controller;

import com.productService.exception.NotFoundException;
import com.productService.model.Product;
import com.productService.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProduct() {
        return productService.getAllProducts();
    }

    /**
     * This function is calling createProduct method to create a product
     * @param product
     * @return
     */
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@Valid @RequestBody Product product) {
        log.info("Entering ProductController.createProduct with parameter product {} ", product);
        productService.createProduct(product);
        return ResponseEntity.ok().body("Product is created successfully");
    }

    /**
     * This function calling findProductById method to get product details
     * @param id
     * @param sellerDetail
     * @return
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable String id, @RequestParam(defaultValue = "false") boolean sellerDetail) {
        log.info("Entering ProductController.findProductById with parameter id {} and sellerDetail {} ", id, sellerDetail);
        if (productService.findProductById(id, sellerDetail).isPresent())
            return ResponseEntity.ok().body(productService.findProductById(id, sellerDetail).get());
        else
            throw new NotFoundException("Product with id : " + id + "not found");
    }

    /**
     * This function is calling updateProduct method to update the existing product
     * @param id
     * @param product
     * @return
     */
    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody Product product) {
        log.info("Entering ProductController.updateProduct with parameter id {} and product {} ", id, product);
        productService.updateProduct(product);
        return ResponseEntity.ok().body("Product is updated successfully");
    }

    /**
     * This function is calling delete method to delete the product
     * @param id
     * @return
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        log.info("Entering ProductController.delete with parameter id {} ", id);
        productService.deleteProductbyId(id);
        return ResponseEntity.ok().body("Product is Deleted successfully");
    }
}