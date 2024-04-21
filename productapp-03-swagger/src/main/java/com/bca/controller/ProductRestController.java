package com.bca.controller;

import com.bca.dto.ProductDto;
import com.bca.entity.Product;
import com.bca.service.ProductService;
import com.bca.util.ProductNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping(path = "products")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @Operation(summary = "Get product by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "found the product",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "400", description = "invalid id supplied", content = @Content(mediaType = "application/json"))})
    @GetMapping(path = "product")
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Product> getById(@RequestParam(name = "id") int id) {
//        if(1==1)
//        throw new ProductNotFoundException("pls give correct id!!!");
//        if(1==1)
//            throw new NullPointerException("pls provide correct id!!!");
        System.out.println("here in controller " + id);
        Product product = productService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping(path = "product")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductDto product) {
        Product product1 = new Product(product.getId(), product.getName(), product.getPrice());
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product1));
    }

    @PutMapping(path = "product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(product));
    }

    @DeleteMapping(path = "product")
    public ResponseEntity<Product> deleteProduct(@RequestParam(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
    }
}

