package com.example.Begin.demo.controller;

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

import com.example.Begin.demo.model.ToDo;
import com.example.Begin.demo.repo.ToDoRepository;
import com.example.Begin.demo.service.ToDoService;

import jakarta.validation.Valid;

@Controller
//@SessionAttributes("name")
public class ToDoControllerJPA {
	
	@Autowired
	private ToDoService todoService;
	
	@Autowired
	private ToDoRepository todoRepository;
	
	public ToDoControllerJPA(ToDoRepository todoRepository, ToDoService todoService) {
		this.todoRepository = todoRepository;
		this.todoService = todoService;
	}
	
	
	@RequestMapping("/todo-list")
	public String getToDo(ModelMap model) {
//		String username = getLoggedInUsername(model);
//		List<ToDo> todos = todoRepository.findByUserName("HARRY");
		List<ToDo> todos = todoRepository.findAll();
		model.addAttribute("todos", todos);
		return "ToDoList";
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String getAddToDo(ModelMap model) {
		ToDo todo = new ToDo(0, "", "", "", LocalDate.now(), false);
		model.put("todo", todo);
		return "AddToDo";
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String AddToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "AddToDo";
		}
		String username = getLoggedInUsername(model);
		todo.setUserName(username);
		todoRepository.save(todo);
		return "redirect:todo-list";
	}
	
	
	@RequestMapping("delete-todo")
	public String deleteToDo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:todo-list";
	}
	
	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String getUpdateToDo(@RequestParam int id, ModelMap model) {
		ToDo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "AddToDo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String getUpdateToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "AddToDo";
		}
		String username = getLoggedInUsername(model);
		todo.setUserName(username);
		todoRepository.save(todo);
		return "redirect:todo-list";
	}
	
	
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // method chain
		return authentication.getName();
	}
	
	
}
