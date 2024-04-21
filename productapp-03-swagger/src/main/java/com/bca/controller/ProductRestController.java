package com.bca.controller;

import com.bca.dto.ProductDto;
import com.bca.entity.Product;
import com.bca.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;

    public ProductRestController() {
    }

    @GetMapping(
            path = {"products"}
    )
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.getAll());
    }

    @Operation(
            summary = "Get product by its id"
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "found all the products",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = Product.class
                    )
            )}
    ), @ApiResponse(
            responseCode = "400",
            description = "invalid id supplied",
            content = {@Content(
                    mediaType = "application/json"
            )}
    )})
    @GetMapping(
            path = {"product"}
    )
    public ResponseEntity<Product> getById(@RequestParam(name = "id") int id) {
        System.out.println("here in controller " + id);
        Product product = this.productService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping(
            path = {"product"}
    )
    public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductDto product) {
        Product product1 = new Product(product.getId(), product.getName(), product.getPrice());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.addProduct(product1));
    }

    @PutMapping(
            path = {"product"}
    )
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.updateProduct(product));
    }

    @DeleteMapping(
            path = {"product"}
    )
    public ResponseEntity<Product> deleteProduct(@RequestParam(name = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.deleteProduct(id));
    }
}
