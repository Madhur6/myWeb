package com.jwt.jwtPrac.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.jwtPrac.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{
	
}
