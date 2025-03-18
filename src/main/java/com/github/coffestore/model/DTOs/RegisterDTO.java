package com.github.coffestore.model.DTOs;

import com.github.coffestore.model.enums.Role;

public record RegisterDTO(String username, String password, Role role) {

}
