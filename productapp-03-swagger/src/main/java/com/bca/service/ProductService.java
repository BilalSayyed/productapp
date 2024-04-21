//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bca.service;

import com.bca.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(int id);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    Product deleteProduct(int id);
}
