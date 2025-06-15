package com.example.Begin.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

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
	
	public void deleteToDo(int id) {
//		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
//		todoList.removeIf(predicate);
		
//		todoList.removeIf(todo -> todo.getId() == id);
		
		for(int i = 0; i < todoList.size(); i++) {
			if (todoList.get(i).getId() == id) {
				todoList.remove(i);
				break;
			}
		}
	}
	
	public ToDo getById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo todo = todoList.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	
	public List<ToDo> getByUsername(String username) {
		Predicate<? super ToDo> predicate = todo -> todo.getUserName() != null && todo.getUserName().equals(username);
		return todoList.stream().filter(predicate).toList();
	}
	
	public void updateToDo(ToDo todo) {
		// Delete it & then add it
		int index = IntStream.range(0, todoList.size())
                .filter(i -> todoList.get(i).getId() == todo.getId()) // Filter by ID
                .findFirst() // Get the first matching index
                .orElse(-1); // Return -1 if not found		

		todoList.set(index, todo);
	}
	
    // @Configuration: Classes annotated 
	
}
