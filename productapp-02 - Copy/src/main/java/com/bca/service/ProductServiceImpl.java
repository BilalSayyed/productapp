package com.bca.service;

import com.bca.dao.ProductRepo;
import com.bca.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo productRepo;
    @Override
    public List<Product> getAll() {
        return productRepo.getAll();
    }

    @Override
    public Product getById(int id) {
        return productRepo.getById(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.updateProduct(product);
    }

    @Override
    public Product deleteProduct(int id) {
        return productRepo.deleteProduct(id);
    }
}
