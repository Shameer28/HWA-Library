package com.qa.library.dto;

import com.qa.library.domain.Library;

public class BooksDTO {
	
	private Integer bookID;
	
	
	private String name;
	
	
	private String author;
	

	
	
	//	CONSTRUCTOR CRUD
	public BooksDTO() {
		
	}
	
	
	//	CONSTRUCTOR
	public BooksDTO(String name, String author, Library library) {
		super();
		this.name = name;
		this.author = author;
	}

	
	//	CONSTRUCTOR
	public BooksDTO(Integer bookID, String name, String author, Library library) {
		super();
		this.bookID = bookID;
		this.name = name;
		this.author = author;
	
	}

	
	//	GETTERS & SETTERS
	public Integer getBookID() {
		return bookID;
	}

	public void setBookID(Integer bookID) {
		this.bookID = bookID;
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

	
}
