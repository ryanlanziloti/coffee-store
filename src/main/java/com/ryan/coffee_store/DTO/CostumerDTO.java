package com.ryan.coffee_store.DTO;

public record CostumerDTO(
    Integer costumer_id,
    String costumer_name,
    String costumer_email,
    String costumer_password
){}
