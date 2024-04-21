//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bca.dao;

import com.bca.entity.Product;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepoImpl implements ProductRepo {
    Map<Integer, Product> products = null;

    public ProductRepoImpl() {
        this.products = new HashMap();
        this.products.put(1, new Product(1, "Laptop", BigDecimal.valueOf(12000L)));
        this.products.put(2, new Product(2, "CoolPad", BigDecimal.valueOf(80000L)));
        this.products.put(3, new Product(3, "NoteBook", BigDecimal.valueOf(200L)));
    }

    public List<Product> getAll() {
        return new ArrayList(this.products.values());
    }

    public Product getById(int id) {
        PrintStream var10000 = System.out;
        String var10001 = String.valueOf(this.products.get(id));
        var10000.println("Here in productDao" + var10001);
        return (Product)this.products.get(id);
    }

    public Product addProduct(Product product) {
        this.products.put(product.getId(), product);
        return product;
    }

    public Product updateProduct(Product product) {
        this.products.remove(product.getId());
        this.products.put(product.getId(), product);
        return product;
    }

    public Product deleteProduct(int id) {
        Product product = (Product)this.products.get(id);
        this.products.remove(id);
        return product;
    }
}
