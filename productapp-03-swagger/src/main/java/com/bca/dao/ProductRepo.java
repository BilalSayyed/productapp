package com.bca.dao;

import com.bca.entity.Product;
import java.util.List;

public interface ProductRepo {
    List<Product> getAll();

    Product getById(int id);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    Product deleteProduct(int id);
}
