package com.example.Begin.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Begin.demo.model.ToDo;
import com.example.Begin.demo.service.ToDoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ToDoController {
	
	@Autowired
	private ToDoService todoService;

	@RequestMapping("/todo-list")
	public String getToDo(ModelMap model) {
		List<ToDo> todos = todoService.getToDo();
		model.addAttribute("todos", todos);
		return "ToDoList";
	}
	

	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String getAddToDo(ModelMap model) {
		ToDo todo = new ToDo("", "", "", LocalDate.now(), false);
		model.put("todo", todo);
		return "AddToDo";
	}
	
	
	
	// @Valid: Validates our POST requests for us...
	// 
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "AddToDo"; // Just stay on the same page / url
		}
		
		String name = (String) model.get("name");
		todoService.addToDo(name, todo.getTaskName(), todo.getDescription(), todo.getDate(), todo.isDone());
		return "redirect:todo-list";
	}
	
	

	
	// /add-todo ---------GET-----------> AddToDo.jsp ----------500 😮 -----------> Binding failed

	
	@RequestMapping("delete-todo")
	public String deleteToDo(@RequestParam int id) {
		todoService.deleteToDo(id);
		return "redirect:todo-list";
	}
	
	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String getUpdateToDoPage(@RequestParam int id, ModelMap model) {
		ToDo todo = todoService.getById(id);
		model.put("todo", todo);
		return "AddToDo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String UpdateToDoPage(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "AddToDo";
		}
		String name = (String) model.get("name");
		todo.setUserName(name);
		todoService.updateToDo(todo);
		return "redirect:todo-list";
	}
	

}











