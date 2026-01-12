package com.servlet.app.service;

import com.servlet.app.dao.UserDAO;
import com.servlet.app.dto.UserDTO;

public class UserService {

    private UserDAO dao;

    public UserService(){
        this.dao = new UserDAO();
    }

    public long register(UserDTO user){
        if(user.getFullName() == null || user.getFullName().trim().isEmpty()){
            throw new IllegalArgumentException("Full name is required.");
        }
        if(user.getEmail() == null || !user.getEmail().contains("@")){
            throw new IllegalArgumentException("Valid email is required.");
        }

        UserDTO userExists = dao.findByEmail(user.getEmail());
        if(userExists != null){
            throw new IllegalArgumentException("Email already exists.");
        }

        boolean inserted = dao.insert(user);
        if(!inserted){
            throw new RuntimeException("Failed to register user.");
        }

        UserDTO savedUser = dao.findByEmail(user.getEmail());
        if(savedUser == null){
            throw new RuntimeException("User not found.");
        }

        return savedUser.getId();
    }
}
