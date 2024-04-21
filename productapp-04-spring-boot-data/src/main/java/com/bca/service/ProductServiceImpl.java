package com.bca.service;

import com.bca.dao.ProductDao;
import com.bca.dao.ProductRepo;
import com.bca.entity.Product;
import com.bca.util.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDao productRepo;
    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepo.findById(id).orElseThrow(()->new ProductNotFoundException("product with id"+id+" not found"));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product deleteProduct(int id) {
      Product product=  productRepo.findById(id).orElseThrow();
        productRepo.delete(product);
        return product;
    }
}
