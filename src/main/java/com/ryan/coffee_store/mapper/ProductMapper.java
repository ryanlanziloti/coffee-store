package com.ryan.coffee_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ryan.coffee_store.DTO.ProductDTO;
import com.ryan.coffee_store.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDto(Product product);

    @Mapping(target="order_items", ignore=true)
    Product toEntity(ProductDTO productDTO);

}
