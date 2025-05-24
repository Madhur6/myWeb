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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myPrac2.practice.model.ToDo;
import com.myPrac2.practice.service.ToDoService;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class ToDoController {
	@Autowired
	private ToDoService todoService;
	
	@RequestMapping("list-todo")
	public String getToDo(ModelMap model) {
		List<ToDo> todoList = todoService.getToDo();
		model.put("todos", todoList);
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
		
//		String username = (String)model.get("name");
		String username = getLoggedInUsername(model);
		todoService.addToDo(username, todo.getTaskName(), todo.getDescription(), todo.getDate(), todo.isDone());
		
		return "redirect:list-todo";
	}
	
	
	@RequestMapping(value="delete-todo")
	public String deleteToDo(@RequestParam int id) {
		todoService.deleteToDo(id);
		return "redirect:list-todo";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String getUpdateToDo(@RequestParam int id, ModelMap model) {
		ToDo todo = todoService.getById(id);
		model.put("todo", todo);
		return "addToDo";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateToDo(@Valid @ModelAttribute("todo") ToDo todo, @RequestParam int id, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "addToDo";
		}
		
//		String username = (String) model.get("name");
		String username = getLoggedInUsername(model);
		todoService.updateToDo(todo, username);
		return "redirect:list-todo";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}


//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.myPrac2.practice.model.ToDo;
//import com.myPrac2.practice.service.ToDoService;

//@Controller
//@SessionAttributes("name")
//public class ToDoController {
//	
//	@Autowired
//	private ToDoService todoService;
//	
//	@RequestMapping("list-todo")
//	public String getToDo(ModelMap model) {
//		List<ToDo> todoList = todoService.getToDo();
//		model.addAttribute("todos", todoList);
////		model.put("todos", todoList);
//		return "todos";        
//	}
//	
//	
//	@RequestMapping(value="add-todo", method=RequestMethod.GET)
//	public String getAddToDo(ModelMap model) {
//		ToDo todo = new ToDo("", "", "", LocalDate.now(), false);
//		model.put("todo", todo);
//		return "addToDo";
//	}
//	
//	@RequestMapping(value="add-todo", method=RequestMethod.POST)
//	public String addToDo(@ModelAttribute("todo") ToDo todo, ModelMap model) {
//		todoService.addToDo(todo.getUsername(), todo.getTaskName(), todo.getDescription(), todo.getDate(), todo.isDone());
//		return "redirect:list-todo";
//	}
//}








