package com.myPrac2.practice.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myPrac2.practice.model.ToDo;
import com.myPrac2.practice.repository.TodoRepository;
import com.myPrac2.practice.service.ToDoService;

import jakarta.validation.Valid;

@Controller
public class ToDoControllerJPA {
	@Autowired
	private ToDoService todoService;
	private TodoRepository todoRepository;
	
	public ToDoControllerJPA(TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}
	
	
	@RequestMapping("list-todo")
	public String getToDo(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<ToDo> todos = todoRepository.findByUsername(username);
		
		model.addAttribute("todos", todos);
		return "todos";
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String getAddToDo(ModelMap model) {
		ToDo todo = new ToDo("", "", "", LocalDate.now(), false);
		model.put("todo", todo);
		return "addToDo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "addToDo";
		}
		
		String username = getLoggedInUsername(model);
//		todoService.addToDo(username, todo.getTaskName(), todo.getDescription(), todo.getDate(), false);
		ToDo added = new ToDo(username, todo.getTaskName(), todo.getDescription(), todo.getDate(), false);
		todoRepository.save(added);
		return "redirect:list-todo";
	}
	
	
	@RequestMapping(value="delete-todo")
	public String deleteToDo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todo";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String getUpdateToDo(@RequestParam int id, ModelMap model) {
		ToDo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "addToDo";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateToDo(@Valid ToDo todo, BindingResult result, @RequestParam int id, ModelMap model) {
		if (result.hasErrors()) {
			return "addToDo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todo";
	}
	
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}




