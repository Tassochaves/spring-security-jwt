package com.dev.springsecurityjwt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dev.springsecurityjwt.entity.User;

public interface UserRepository extends CrudRepository<User, String>{

    Optional<User> findByUsername(String username);
    
}
