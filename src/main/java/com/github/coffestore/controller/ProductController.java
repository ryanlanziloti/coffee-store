package com.github.coffestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.coffestore.model.Product;
import com.github.coffestore.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    //GET
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@RequestParam  Long id) {
        return productService.getProductById(id);
    }

    //POST
    @PostMapping
    public Product createProduct(Product product) {
        return productService.saveProduct(product);
    }

    //PUT
    @PutMapping("/{id}")
    public Product updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteProduct(Long id) {
        productService.deleteProductById(id);
    }
}
