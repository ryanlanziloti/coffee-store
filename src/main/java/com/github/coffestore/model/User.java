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

@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String username;

    @Column(name = "user_email", nullable = false, length = 50)
    private String user_email;

    @Column(name = "user_password", nullable = false, length = 50)
    private String password;

    @Enumerated(EnumType.STRING)   
    @Column(name = "user_role", nullable = false, length = 5)
    private Role user_role;

    public User(){}

    public int getUser_id() {
            return user_id;
        }
    
        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }
    
        public String getUsername() {
            return username;
        }
    
        public void setUsername(String username) {
            this.username = username;
        }
    
        public String getUser_email() {
            return user_email;
        }
    
        public void setUser_email(String user_email) {
            this.user_email = user_email;
        }
    
        public String getPassword() {
            return password;
        }
    
        public void setPassword(String password) {
            this.password = password;
        }
    
        public Role getUser_role() {
            return user_role;
        }
    
        public void setUser_role(Role user_role) {
            this.user_role = user_role;
        }
    
}
