package com.hostel.myHostel.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hostel.myHostel.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
