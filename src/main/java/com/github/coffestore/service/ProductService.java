package com.github.coffestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.coffestore.model.Product;
import com.github.coffestore.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //FIND ALL PRODUCTS
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //FIND PRODUCT BY ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    //SAVE PRODUCT
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    //DELETE PRODUCT BY ID
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    //UPDATE PRODUCT
    public Product updateProduct(Long id,Product product) {
        return productRepository.save(product);
    }
}
