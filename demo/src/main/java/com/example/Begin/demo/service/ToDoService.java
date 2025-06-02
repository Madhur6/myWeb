package com.example.Begin.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Begin.demo.model.ToDo;

@Service
public class ToDoService {
	private static List<ToDo> todoList = new ArrayList<>();
	private static int counter = 3;
	
	static {
		todoList.add(new ToDo(1, "harry", "learning", "learning-spring-boot", LocalDate.now().plusYears(1), false));
		todoList.add(new ToDo(2, "harry", "learning", "learning-angular", LocalDate.now().plusYears(2), false));
		todoList.add(new ToDo(3, "harry", "learning", "learning-advance-java", LocalDate.now().plusYears(3), false));
	}
	
	public List<ToDo> getToDo(){
		return todoList;
	}
	
	public void addToDo(String username, String taskname, String description, LocalDate date, boolean done) {
		todoList.add(new ToDo(++counter, username, taskname, description, date, done));
	}
	
	
}
