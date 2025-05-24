package com.prac.myPrac.controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.prac.myPrac.model.ToDo;
import com.prac.myPrac.service.todoService;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class todoController {
	
	@Autowired
	private todoService todoservice;
	
	@RequestMapping("list-todo")
	public String getToDo(ModelMap model) {
		List<ToDo> todos = todoservice.getToDo();
//		System.out.println(todos);
		model.addAttribute("todos", todos);
		return "ToDoList";
	}
	
	@RequestMapping("list-todo1")
	public String getToDo1(ModelMap model) {
//		String username = (String) model.get("name");
		String username = getLoggedInUsername(model);
		List<ToDo> todos = todoservice.getToDoByUsername(username);
		model.addAttribute("todos", todos);
		return "ToDoList";
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String getAddToDo(ModelMap model) {
		ToDo todo = new ToDo("", "", LocalDate.now(), false);
		model.put("todo", todo);
		return "addToDo";
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "addToDo";
		}
		
//		todoservice.addToDo(todo.getTaskName(), todo.getDescription(), todo.getDate(), false);
		// IF NOT USING TODOCONTROLLERJPA, UPDATE THIS [ADD USERNAME]
		
		return "redirect:list-todo";
	}
	
	
	@RequestMapping(value="add-todo1", method=RequestMethod.GET)
	public String getAddToDo1(ModelMap model) {
		ToDo todo = new ToDo("", "", "", LocalDate.now(), false);
		model.put("todo", todo);
		return "addToDo";
	}
	
	
	@RequestMapping(value="add-todo1", method=RequestMethod.POST)
	public String addToDo1(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "addToDo";
		}
//		String username = (String) model.get("name");
		String username = getLoggedInUsername(model);
		todoservice.addToDo1(username, todo.getTaskName(), todo.getDescription(), todo.getDate(), false);
		
		return "redirect:list-todo";
	}
	
	
	@RequestMapping(value="delete-todo")
	public String deleteToDo(@RequestParam int id) {
		todoservice.deleteToDo(id);
		return "redirect:list-todo";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String getUpdateToDo(@RequestParam int id, ModelMap model) {
		ToDo todo = todoservice.getById(id);
		model.put("todo",todo);
		return "addToDo";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateToDo(@Valid @ModelAttribute("todo") ToDo todo, @RequestParam int id, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "addToDo";
		}
		
		todoservice.updateToDo(todo);
		return "redirect:list-todo";
	}
	
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}









