package com.bca.service;

import com.bca.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product getById(int id);
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(int id);
    public void evictAll();
}
