package com.bca.dao;

import com.bca.entity.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepoImpl implements ProductRepo{
    Map<Integer,Product> products=null;

    public ProductRepoImpl()
    {
        products=new HashMap<>();
        products.put(1,new Product(1,"Laptop", BigDecimal.valueOf(12000)));
        products.put(21,new Product(2,"CoolPad",BigDecimal.valueOf(80000)));
        products.put(3,new Product(3,"NoteBook",BigDecimal.valueOf(200)));
    }
    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getById(int id) {
        return products.get(id);
    }

    @Override
    public Product addProduct(Product product) {
        products.put(product.getId(),product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        products.remove(product.getId());
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public Product deleteProduct(int id) {
        Product product=products.get(id);
        products.remove(id);
        return product;
    }
}
