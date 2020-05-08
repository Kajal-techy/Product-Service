package com.productService.service;

import com.productService.dao.ProductDao;
import com.productService.exception.NotFoundException;
import com.productService.model.Product;
import com.productService.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * This function is creating product
     * @param product
     */
    @Override
    public void createProduct(Product product) {
        log.info("Entering ProductServiceImpl.createProduct");
        productDao.save(product);
    }

    /**
     *  This function is fetching all products
     * @return
     */
    @Override
    public List<Product> getAllProducts() {
        log.info("Entering ProductServiceImpl.getAllProducts");
        return productDao.getAllProducts();

    }

    /**
     * This function is fetching product by Id
     * @param id
     * @param sellerDetail
     * @return
     */
    @Override
    public Optional<Product> findProductById(String id, boolean sellerDetail) {
        log.info("Entering ProductServiceImpl.findProductById with parameters id {} and sellerDetail {}", id, sellerDetail);
        if (productDao.getProductById(id).isPresent()) {
            Product product = productDao.getProductById(id).get();
            User[] user;
            if (sellerDetail) {
                user = productDao.getUserByUserName(product.getSellerDetails().getUserName());
                product.setSellerDetails(user[0]);
            }
            return Optional.of(product);
        } else
            throw new NotFoundException("Product with Id : " + id + "Not found");
    }

    /**
     * This Function is deleting product by Id
     * @param id
     */
    @Override
    public void deleteProductbyId(String id) {
        log.info("Entering ProductServiceImpl.deleteProductbyId");
        productDao.deleteProductById(id);
    }

    /**
     * This function will update product
     * @param product
     */
    @Override
    public void updateProduct(Product product) {
        log.info("Entering ProductServiceImpl.updateProduct");
        productDao.save(product);
    }

    @Override
    public void deleteAllProducts() {
        // TODO Auto-generated method stub
    }
}