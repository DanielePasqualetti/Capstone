package com.epicode.Capstone.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.Capstone.security.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
    
    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
    List<User> findByName(String name);
    
    List<User> findByLastname(String lastname);
}
