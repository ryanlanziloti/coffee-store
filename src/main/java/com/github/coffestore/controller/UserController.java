package com.github.coffestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import com.github.coffestore.model.User;
import com.github.coffestore.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    //GET
    @GetMapping  
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
 
 

    //POST
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //PUT
    @PutMapping("/{id}")
    public User updateUser(@RequestParam int id,@RequestBody User newUser){
        return userService.updateUser(id, newUser);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteUser(@RequestParam int id){
        userService.deleteUser(id);
    }
    
}
