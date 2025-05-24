package com.myPrac2.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myPrac2.practice.model.ToDo;

public interface TodoRepository extends JpaRepository<ToDo, Integer> {
	public List<ToDo> findByUsername(String username);
}
