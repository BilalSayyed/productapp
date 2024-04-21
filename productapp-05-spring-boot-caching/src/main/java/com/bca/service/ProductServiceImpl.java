package com.bca.service;

import com.bca.dao.ProductDao;
import com.bca.dao.ProductRepo;
import com.bca.entity.Product;
import com.bca.util.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productRepo;
    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    @Cacheable(
            value = "products"
    )
    public List<Product> getAll() {
        logger.info("db is hit for get all");
        return productRepo.findAll();
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public Product getById(int id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("product with id" + id + " not found"));
    }

    @Override
    @CachePut(value = "products", key = "#result.id")
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    @CacheEvict(value = "products", key = "#id")
    public Product deleteProduct(int id) {
        Product product = productRepo.findById(id).orElseThrow();
        productRepo.delete(product);
        return product;
    }

    @CacheEvict(value = "products", allEntries = true)
    public void evictAll() {
        logger.info("evictAll called");
    }
}
