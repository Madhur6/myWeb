package com.healthTrackerApp.health_tracker_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.healthTrackerApp.health_tracker_app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
