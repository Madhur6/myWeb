package com.example.Begin.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class ToDo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	private String userName;
	private String taskName;
	
	private String description;
	private LocalDate date;
	private boolean done;
	
	public ToDo() {
		super();
	}
	
	public ToDo(int id, String userName, String taskName, String description, LocalDate date, boolean done) {
		super();
		this.id = id;
		this.userName = userName;
		this.taskName = taskName;
		this.description = description;
		this.date = date;
		this.done = done;
	}
	
	public ToDo(String userName, String taskName, String description, LocalDate date, boolean done) {
		super();
		this.userName = userName;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	@Size(min=10, message="Atleast 10 characters are required!")
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
}
