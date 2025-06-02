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

import com.example.Begin.demo.model.ToDo;
import com.example.Begin.demo.service.ToDoService;

import jakarta.validation.Valid;

@Controller
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
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addToDo(@ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "AddToDo"; // Just stay on the same page / url
		}
		
		todoService.addToDo(todo.getUserName(), todo.getTaskName(), todo.getDescription(), todo.getDate(), todo.isDone());
		return "redirect:todo-list";
	}
	
	// /add-todo ---------GET-----------> AddToDo.jsp ----------500 😮 -----------> Binding failed

	
}











