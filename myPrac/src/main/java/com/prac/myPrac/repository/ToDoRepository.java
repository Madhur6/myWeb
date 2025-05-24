package com.prac.myPrac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prac.myPrac.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer>{
	public List<ToDo> findByUsername(String username);
}
