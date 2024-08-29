package com.springrest.springrest.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entity.Login;

import java.util.Optional;

@Repository
public interface loginDao extends JpaRepository<Login, Long> {
    Optional<Login> findByUsernameAndPassword(String username, String password);

	Optional<Login> findByUsername(String username);
}
 