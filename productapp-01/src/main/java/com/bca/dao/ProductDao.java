package com.bca.dao;

import com.bca.entity.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getAll();
    public Product getById(int id);
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(int id);

}
