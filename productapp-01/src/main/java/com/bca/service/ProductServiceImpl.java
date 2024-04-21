package com.bca.service;

import com.bca.dao.ProductDao;
import com.bca.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDao productDao;
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product getById(int id) {
        return productDao.getById(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public Product deleteProduct(int id) {
        return productDao.deleteProduct(id);
    }
}
