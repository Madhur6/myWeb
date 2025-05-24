package com.todoapp.myFirstWebApp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer>{
	public List<ToDo> findByUsername(String username);
}
