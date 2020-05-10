package com.productService.controller;

import com.productService.exception.DependencyFailureException;
import com.productService.model.Product;
import com.productService.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
     *
     * @param product
     * @return
     */
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) throws DependencyFailureException {
        log.info("Entering ProductController.createProduct with parameter product {} ", product);
        Optional<Product> productOptional = productService.createProduct(product);
        if (productOptional.isPresent())
            return ResponseEntity.ok().body(productOptional.get());
        else
            throw new DependencyFailureException("Failed to create a product");
    }

    /**
     * This function calling findProductById method to get product details
     *
     * @param id
     * @param sellerDetail
     * @return
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable String id, @RequestParam(defaultValue = "false") boolean sellerDetail) throws DependencyFailureException {
        log.info("Entering ProductController.findProductById with parameter id {} and sellerDetail {} ", id, sellerDetail);
        Optional<Product> productOptional = productService.findProductById(id, sellerDetail);
        if (productOptional.isPresent())
            return ResponseEntity.ok().body(productOptional.get());
        else
            throw new DependencyFailureException("Failed to find a product");
    }

    /**
     * This function is calling updateProduct method to update the existing product
     *
     * @param id
     * @param product
     * @return
     */
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) throws DependencyFailureException {
        log.info("Entering ProductController.updateProduct with parameter id {} and product {} ", id, product);
        Optional<Product> productOptional = productService.updateProduct(product);
        if (productOptional.isPresent())
            return ResponseEntity.ok().body(productOptional.get());
        else
            throw new DependencyFailureException("Failed to find a product");
    }


    /**
     * This function is calling delete method to delete the product
     *
     * @param id
     * @return
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        log.info("Entering ProductController.delete with parameter id {} ", id);
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}