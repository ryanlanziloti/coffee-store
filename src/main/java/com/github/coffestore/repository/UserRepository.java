package com.github.coffestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.github.coffestore.model.User; 


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    UserDetails findByUsername(String username);
}
