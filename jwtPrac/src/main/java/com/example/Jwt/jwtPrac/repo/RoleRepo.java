package com.example.Jwt.jwtPrac.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jwt.jwtPrac.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
	
}
