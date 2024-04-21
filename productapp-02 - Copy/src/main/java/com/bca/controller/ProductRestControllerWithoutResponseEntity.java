//package com.bca.controller;
//
//import com.bca.entity.Product;
//import com.bca.service.ProductService;
//import com.bca.util.ProductNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class ProductRestControllerWithoutResponseEntity {
//    @Autowired
//    private ProductService productService;
//    @GetMapping(path = "products")
//    public List<Product> getAll()
//    {
////        if(1==1)
////            throw new NullPointerException("some big issue");
//        return productService.getAll();
//    }
//    @GetMapping(path = "product")
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Product getById(@RequestParam(name = "id") int id)
//    {
//        if(1==1)
//            throw new ProductNotFoundException("some big issue");
//        return productService.getById(id);
//    }
//    @PostMapping(path = "product")
//    public Product addProduct(@RequestBody Product product)
//    {
//        return productService.addProduct(product);
//    }
//    @PutMapping(path = "product")
//    public Product updateProduct(@RequestBody Product product)
//    {
//        return productService.updateProduct(product);
//    }
//    @DeleteMapping(path = "product")
//    public Product deleteProduct(@RequestParam(name = "id") int id)
//    {
//        return productService.deleteProduct(id);
//    }
//}
