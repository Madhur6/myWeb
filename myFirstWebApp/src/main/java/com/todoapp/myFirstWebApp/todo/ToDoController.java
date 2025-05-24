package com.todoapp.myFirstWebApp.todo;

import java.time.LocalDate;
import java.util.List;

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

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class ToDoController {
	private ToDoService todoService;
	
	public ToDoController(ToDoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	
	@RequestMapping("home")
	public String welcomePage(ModelMap model) {
		return "welcome";
	}
	
	@RequestMapping("list-todos")
	public String ListAllToDos(ModelMap model) {
		List<ToDo> todos = todoService.findByUsername("practice");
		model.addAttribute("todos", todos);
		
		return "listToDos";
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewToDoPage(ModelMap model) {
		String username = (String) model.get("name");
		ToDo todo = new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
//		model.addAttribute(new ToDo());
		return "todo";
	}
	
//  1st approach................................
//	@RequestMapping(value="add-todo", method=RequestMethod.POST)
//	public String addNewToDo(@RequestParam String description, ModelMap model) {
//		String username = (String) model.get("name");
//		todoService.addToDo(username, description, LocalDate.now().plusYears(1), false);
//		
//		return "redirect:list-todos";
//	}
	
//  2nd approach................................
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewToDo(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "todo";
		}
		
		String username = (String) model.get("name");
		todoService.addToDo(username, todo.getDescription(), todo.getTargetDate(), false);
		
		return "redirect:list-todos";
	}
	
	
	@RequestMapping("delete-todo")
	public String deleteToDo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateToDo(@RequestParam int id, ModelMap model) {
		ToDo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateToDo(@RequestParam int id, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "todo";
		}
		
		String username = (String) model.get("name");
		todo.setUsername(username);
		todoService.updateToDo(todo);
		return "redirect:list-todos";
	}
	
	
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
	
	
}











