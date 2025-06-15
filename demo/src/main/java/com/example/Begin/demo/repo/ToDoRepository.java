package com.example.Begin.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Begin.demo.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer>{
	public List<ToDo> findByUserName(String username);
}
