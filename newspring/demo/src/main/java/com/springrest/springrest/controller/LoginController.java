package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springrest.springrest.entity.Login;
import com.springrest.springrest.server.LoginServer;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginServer loginServer;

    // Login endpoint
    @PostMapping("/login") 
    public Map<String, Object> loginUser(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        boolean isValidUser = loginServer.validateUser(username, password);

        Map<String, Object> response = new HashMap<>();
        response.put("success", isValidUser);

        if (isValidUser) {
            // Additional login success handling, like generating a JWT token
            response.put("message", "Login successful");
        } else {
            response.put("message", "Invalid credentials");
        }

        return response;
    }

    // Registration endpoint
    @PostMapping("/register")
    public Map<String, Object> registerUser(@RequestBody Login login) {
        boolean userExists = loginServer.checkUsernameExists(login.getUsername());

        Map<String, Object> response = new HashMap<>();
        if (userExists) {
            response.put("success", false);
            response.put("message", "Username already exists");
        } else {
            Login savedUser = loginServer.registerUser(login);
            response.put("success", true);
            response.put("message", "Registration successful");
            response.put("user", savedUser); 
        }

        return response;
    }
}
