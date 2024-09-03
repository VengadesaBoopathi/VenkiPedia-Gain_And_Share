package com.springrest.springrest.server;

import com.springrest.springrest.entity.Login;

public interface LoginServer {

	public boolean validateUser(String username, String password);

	boolean checkUsernameExists(String username);

	Login registerUser(Login login);

}
