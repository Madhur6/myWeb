package com.jwt.jwtPrac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.jwt.jwtPrac.model.Role;
import com.jwt.jwtPrac.model.User;
import com.jwt.jwtPrac.repo.RoleRepo;
import com.jwt.jwtPrac.repo.UserRepo;

public class AppRunner implements ApplicationRunner {

	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role role1 = new Role();
		role1.setRoleName("ADMIN");
		
		Role role2 = new Role();
		role2.setRoleName("USER");
		
		Role saveRole1 = roleRepo.save(role1);
		Role saveRole2 = roleRepo.save(role2);
		
		
		User user = new User();
		user.setEmail("harry@gmail.com");
		user.setPass("123");
		user.setRole(saveRole1);
		
		User user1 = new User();
		user1.setEmail("ron@gmail.com");
		user1.setPass("456");
		user1.setRole(saveRole2);
		
		
		User user2 = new User();
		user2.setEmail("hermionne@gmail.com");
		user2.setPass("321");
		user2.setRole(saveRole2);
		
		userRepo.save(user);
		userRepo.save(user1);
		userRepo.save(user2);
		
	}

}
