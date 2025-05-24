package com.prac.myPrac.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.prac.myPrac.model.ToDo;

import jakarta.validation.Valid;

@Service
public class todoService {
	private static List<ToDo> todoList = new ArrayList<>();
	
	private static int counter = 3;
	
//	
//	static {
//		todoList.add(new ToDo(1, "myPrac", "learning sb", LocalDate.now().plusYears(1), false));
//		todoList.add(new ToDo(2, "myPrac", "learning angular", LocalDate.now().plusYears(2), false));
//		todoList.add(new ToDo(3, "myPrac", "learning git", LocalDate.now().plusYears(3), false));
//	}

	
	public List<ToDo> getToDo() {
//		System.out.println(todoList);
		return todoList;
	}
	
	public List<ToDo> getToDoByUsername(String username){
		Predicate<? super ToDo> predicate = todo -> todo.getUsername() != null && todo.getUsername().equalsIgnoreCase(username);
		return todoList.stream().filter(predicate).toList();
	}
	
	
	public void addToDo(String username, String taskName, String description, LocalDate date, boolean done) {
		ToDo todo = new ToDo(++counter, username, taskName, description, date, done);
		todoList.add(todo);
	}
	
	public void addToDo1(String username, String taskName, String description, LocalDate date, boolean done) {
		ToDo todo = new ToDo(++counter, username, taskName, description, date, done);
		todoList.add(todo);
	}
	
	public ToDo getById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo todo = todoList.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	
	public void deleteToDo(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		todoList.removeIf(predicate);
	}
	

	public void updateToDo(@Valid ToDo todo) {
		deleteToDo(todo.getId());
		todoList.add(todo);
	}
	
}
