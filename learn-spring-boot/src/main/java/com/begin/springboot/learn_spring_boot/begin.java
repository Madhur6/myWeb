package com.begin.springboot.learn_spring_boot;

// bean: pojo (plain old java object)

//@Entity
public class begin {
	private long id;
	private String name;
	private String author;
	
	// Constructor
	public begin() {
		
	}
	
	public begin(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	// getter & setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	@Override
	public String toString() {
		return "begin [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
}
