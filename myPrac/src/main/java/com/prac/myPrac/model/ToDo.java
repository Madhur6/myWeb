package com.prac.myPrac.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class ToDo {
	@Id
	@GeneratedValue()
	private int id;
	private String username;
	private String taskName;
	
	@Size(min=10, message="Enter atleast 10 characters!")
	private String description;
	private LocalDate date;
	private boolean done;
	
	public ToDo() {
		
	}
	

	public ToDo(String username, String taskName, String description, LocalDate date, boolean done) {
		this.username = username;
		this.taskName = taskName;
		this.description = description;
		this.date = date;
		this.done = done;
	}

	
	public ToDo(int id, String username, String taskName, String description, LocalDate date, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.taskName = taskName;
		this.description = description;
		this.date = date;
		this.done = done;
	}
	

	public ToDo(String taskName, String description, LocalDate date, boolean done) {
		this.taskName = taskName;
		this.description = description;
		this.date = date;
		this.done = done;
	}

	
	public ToDo(int id, String taskName, String description, LocalDate date, boolean done) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.description = description;
		this.date = date;
		this.done = done;
	}

	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	
	@Override
	public String toString() {
		return "Id: " + this.id + " | Task Name: " + this.taskName + " | Description: " + this.description + " | date: " + this.date + " | done: " + this.done;
	}
}
