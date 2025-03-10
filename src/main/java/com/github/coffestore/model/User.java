package com.github.coffestore.model;

import com.github.coffestore.model.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*; 

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String user_name;

    @Column(name = "user_email", nullable = false, length = 50)
    private String user_email;

    @Column(name = "user_password", nullable = false, length = 50)
    private String user_password;

    @Enumerated(EnumType.STRING)   
    @Column(name = "user_role", nullable = false, length = 5)
    private Role user_role;

    public User(){}
}
