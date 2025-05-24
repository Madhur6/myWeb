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

@Controller
@SessionAttributes("name")
public class ToDoControllerJPA {
	private ToDoService todoService;
	private ToDoRepository todoRepository;
	
	public ToDoControllerJPA(ToDoService todoService, ToDoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		
		List<ToDo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listToDos";
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewToDoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		ToDo todo = new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewToDo(ModelMap model, @Valid ToDo todo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
//		todoService.addToDo(username, todo.getDescription(), todo.getTargetDate(), false);

		return "redirect:list-todos";
	}
	
	
	@RequestMapping("delete-todo")
	public String deleteToDo(@RequestParam int id) {
//		todoService.deleteById(id);
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateToDo(@RequestParam int id, ModelMap model) {
//		ToDo todo = todoService.findById(id);
		ToDo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateToDo(@RequestParam int id, @Valid ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "todo";
		}
		
		String username = (String) model.get("name");
		todo.setUsername(username);
//		todoService.updateToDo(todo);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
}
