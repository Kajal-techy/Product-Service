package com.productService.service;

import com.productService.dao.ProductDao;
import com.productService.dao.UserDao;
import com.productService.exception.DependencyFailureException;
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
    private final UserDao userDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao, UserDao userDao) {
        this.productDao = productDao;
        this.userDao = userDao;
    }

    /**
     * This function is creating product
     *
     * @param product
     */
    @Override
    public Optional<Product> createProduct(Product product) {
        log.info("Entering ProductServiceImpl.createProduct");
        return productDao.save(product);
    }

    /**
     * This function is fetching all products
     *
     * @return
     */
    @Override
    public List<Product> getAllProducts() {
        log.info("Entering ProductServiceImpl.getAllProducts");
        return productDao.getAllProducts();
    }

    /**
     * This function is fetching product by Id
     *
     * @param id
     * @param sellerDetail
     * @return
     */
    @Override
    public Optional<Product> findProductById(String id, boolean sellerDetail) throws DependencyFailureException {
        log.info("Entering ProductServiceImpl.findProductById with parameters id {} and sellerDetail {}", id, sellerDetail);
        Optional<Product> productOptional = productDao.getProductById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            List<User> user;
            if (product.getSellerDetails() != null && sellerDetail) {
                user = userDao.getUserByUserName(product.getSellerDetails().getUserName());
                product.setSellerDetails(user.get(0));
            }
            return Optional.of(product);
        } else
            return Optional.empty();
    }

    /**
     * This Function is deleting product by Id
     *
     * @param id
     */
    @Override
    public void deleteProductById(String id) {
        log.info("Entering ProductServiceImpl.deleteProductbyId");
        productDao.deleteProductById(id);
    }

    /**
     * This function will update product
     *
     * @param product
     */
    @Override
    public Optional<Product> updateProduct(Product product) {
        log.info("Entering ProductServiceImpl.updateProduct");
        return productDao.save(product);
    }
}