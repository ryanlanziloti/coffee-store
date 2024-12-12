package com.ryan.coffee_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.coffee_store.DTO.ProductDTO;
import com.ryan.coffee_store.mapper.ProductMapper;
import com.ryan.coffee_store.model.Product;
import com.ryan.coffee_store.repository.ProductRepository;



@Service
public class ProductService {
  
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    //GET
    public List<ProductDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> productMapper.toDto(product)).toList();
    }

    public ProductDTO getById(Integer id){

        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado."));

        return productMapper.toDto(product);
    }

    //UPDATE
    public ProductDTO updateProduct(Integer id, ProductDTO newProduct){

        Product product = productMapper.toEntity(getById(id));

        product.setProduct_name(newProduct.product_name());
        product.setProduct_description(newProduct.product_description());
        product.setProduct_price(newProduct.product_price());
        product.setStock_quantity(newProduct.stock_quantity());

        return productMapper.toDto(productRepository.save(product));
    }

    //CREATE
    public ProductDTO createProduct(ProductDTO newProduct){
        
        Product product = productMapper.toEntity(newProduct);

        productRepository.save(product);

        return newProduct;
    }
    
    //DELETE
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    } 
}
