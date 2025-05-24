package com.todoapp.myFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.todoapp.myFirstWebApp.todo.ToDo;

import jakarta.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	private static List<ToDo> todos = new ArrayList<>();
	
	private static int todosCount = 4;
	
//	public List<ToDo> findByUsername (String username) {
//		return todos;
//	}
//	
	// A block of code that is loaded only once, When the entire code is compiled for the first time...
	static {
		todos.add(new ToDo(1, "practice", "Learn spring-boot", LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(2, "practice", "Learn angular", LocalDate.now().plusYears(2), false));
		todos.add(new ToDo(3, "practice", "Learn aws", LocalDate.now().plusYears(3), false));
		todos.add(new ToDo(4, "practice1", "Learn flutter", LocalDate.now().plusYears(4), false));	
	}
	
	public void addToDo(String username, String description, LocalDate targetDate, boolean done) {
		ToDo todo = new ToDo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	
	public void deleteById(int id) {
		// todo.getId() == id --> delete
		// todo -> todo.getId() == id;
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		todosCount--;
		todos.removeIf(predicate);
	}


	public ToDo findById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}


	public void updateToDo(@Valid ToDo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
	
	
	public List<ToDo> findByUsername(String username){
		Predicate<? super ToDo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		
		return todos.stream().filter(predicate).toList();
	}
}






