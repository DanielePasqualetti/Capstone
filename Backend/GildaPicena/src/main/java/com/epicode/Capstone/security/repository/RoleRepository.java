package com.epicode.Capstone.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.Capstone.security.entity.ERole;
import com.epicode.Capstone.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
