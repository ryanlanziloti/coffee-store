package com.ryan.coffee_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ryan.coffee_store.DTO.CostumerDTO;
import com.ryan.coffee_store.model.Costumer;

@Mapper(componentModel = "spring")
public interface CostumerMapper {

    CostumerMapper INSTANCE = Mappers.getMapper( CostumerMapper.class);

    CostumerDTO toDto(Costumer costumer);

    @Mapping(target="orders", ignore=true)
    Costumer toEntity(CostumerDTO costumerDTO);

}
