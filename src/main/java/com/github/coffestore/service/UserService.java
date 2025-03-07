package com.github.coffestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.coffestore.model.User;
import com.github.coffestore.repository.UserRepository;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;
 
    //RETURN ALL USERS
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //RETURN USER BY ID
    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    //CREATE USER
    public User createUser(User user){
        return userRepository.save(user);
    }

    //UPDATE USER
    public User updateUser(int id, User newUser){
        User user = getUserById(id);
        user.setUser_name(newUser.getUser_name());
        user.setUser_password(newUser.getUser_password());
        user.setUser_role(newUser.getUser_role());
        return userRepository.save(user);
    }

    //DELETE USER
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
