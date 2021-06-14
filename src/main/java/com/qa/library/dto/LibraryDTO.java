package com.qa.library.dto;

import java.util.List;

public class LibraryDTO {
	
	private Integer libID;
	
	private String name;
	
	private List<BooksDTO> book;

	
	
	//CONSTRUCTORS
	public LibraryDTO() {
		
	}


	public LibraryDTO(String name, List<BooksDTO> book) {
		super();
		this.name = name;
		this.book = book;
	}


	public LibraryDTO(Integer libID, String name, List<BooksDTO> book) {
		super();
		this.libID = libID;
		this.name = name;
		this.book = book;
	}

	//GETTERS & SETTERS
	public Integer getLibID() {
		return libID;
	}


	public void setLibID(Integer libID) {
		this.libID = libID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<BooksDTO> getBook() {
		return book;
	}


	public void setBook(List<BooksDTO> book) {
		this.book = book;
	}
	
	
}