package com.hostel.myHostel.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hostel.myHostel.model.Property;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByLocation(String location);
}
