package com.ryan.coffee_store.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.coffee_store.model.Product;
import com.ryan.coffee_store.repository.ProductRepository;



@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    //GET
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Integer id){
        return productRepository.findById(id)
                                .orElseThrow(() -> new NoSuchElementException("No product founded"));
    }

    //UPDATE
    public Product updateProduct(Integer id, Product newProduct){

        Product product = getProductById(id);

        product.setProduct_name(newProduct.getProduct_name());
        product.setProduct_description(newProduct.getProduct_description()); 
        product.setProduct_price(newProduct.getProduct_price()); 
        product.setStock_quantity(newProduct.getStock_quantity()); 

        return productRepository.save(product);
    }

    //CREATE
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    //DELETE
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

}
