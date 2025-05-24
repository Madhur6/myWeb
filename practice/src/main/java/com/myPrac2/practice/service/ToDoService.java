package com.myPrac2.practice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.myPrac2.practice.model.ToDo;

import jakarta.validation.Valid;

@Service
public class ToDoService {
	private static List<ToDo> todoList = new ArrayList<>();
	private static int counter = 3;
	
//	static {
//		todoList.add(new ToDo(1, "practice", "learn", "Learn spring-boot", LocalDate.now().plusYears(1), false));
//		todoList.add(new ToDo(2, "practice", "learn", "Learn angular", LocalDate.now().plusYears(2), false));
//		todoList.add(new ToDo(3, "practice", "learn", "Learn Python", LocalDate.now().plusYears(3), false));
//	}
	
	public void addToDo(String username, String taskName, String description, LocalDate date, boolean done) {
		todoList.add(new ToDo(++counter, username, taskName, description, date, done));
	}
	
	public List<ToDo> getToDo(){
		return todoList;
	}
	
	
	public void deleteToDo(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		todoList.removeIf(predicate);
	}
	
	
	public ToDo getById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo todo = todoList.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	
	public void updateToDo(@Valid ToDo todo, String username) {
		deleteToDo(todo.getId());
		todo.setUsername(username);
		todoList.add(todo);
		
	}
	
	
	
	
	
	
}

//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.myPrac2.practice.model.ToDo;

//@Service
//public class ToDoService {
//	private static List<ToDo> todoList = new ArrayList<>();
//	private static int counter = 3;
//	
//	static {
//		todoList.add(new ToDo(1, "username", "practice", "learning-spring-boot", LocalDate.now().plusYears(1), false));
//		todoList.add(new ToDo(2, "username", "practice", "learning-angular", LocalDate.now().plusYears(2), false));
//	}
//	
//	public List<ToDo> getToDo(){
//		return todoList;
//	}
//	
//	public void addToDo(String username, String taskName, String description, LocalDate date, boolean done) {
//		ToDo todo = new ToDo(counter++, username, taskName, description, date, done);
//		todoList.add(todo);
//	}
//}
