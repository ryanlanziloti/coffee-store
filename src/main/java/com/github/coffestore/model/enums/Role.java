package com.github.coffestore.model.enums;


public enum Role {
    ADMIN, USER;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
