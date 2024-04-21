//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bca.service;

import com.bca.dao.ProductRepo;
import com.bca.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    public ProductServiceImpl() {
    }

    public List<Product> getAll() {
        return this.productRepo.getAll();
    }

    public Product getById(int id) {
        System.out.println(this.productRepo.getById(id));
        return this.productRepo.getById(id);
    }

    public Product addProduct(Product product) {
        return this.productRepo.addProduct(product);
    }

    public Product updateProduct(Product product) {
        return this.productRepo.updateProduct(product);
    }

    public Product deleteProduct(int id) {
        return this.productRepo.deleteProduct(id);
    }
}
