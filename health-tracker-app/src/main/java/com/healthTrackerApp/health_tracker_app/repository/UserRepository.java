package com.healthTrackerApp.health_tracker_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthTrackerApp.health_tracker_app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}










// Model : User (@Entity,@Id Datatype)

// JPA: java persistent api

// JDBC ("Select username, password from user where username=? and password=?");

// findById
// findByUsername
// findByEmail
// findByPassword