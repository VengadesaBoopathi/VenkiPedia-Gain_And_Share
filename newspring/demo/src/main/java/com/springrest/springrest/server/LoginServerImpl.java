package com.springrest.springrest.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Dao.loginDao;
import com.springrest.springrest.entity.Login;

import java.util.Optional;

@Service
public class LoginServerImpl implements LoginServer {

    @Autowired
    private loginDao logindao;

    // Method to validate user during login
    @Override
    public boolean validateUser(String username, String password) {
        Optional<Login> user = logindao.findByUsernameAndPassword(username, password);
        return user.isPresent();
    }

    // Method to check if a username already exists in the database
    @Override
    public boolean checkUsernameExists(String username) {
        Optional<Login> user = logindao.findByUsername(username);
        return user.isPresent();
    } 

    // Method to register a new user
    @Override
    public Login registerUser(Login login) {
        return logindao.save(login);
    }
}
