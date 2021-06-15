package com.qa.library.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Library {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //AUTO INCREMENT
	private Integer libID;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "library")
	
	private List<Book> book = new ArrayList<>();;
	

	//	GETTERS & SETTERS
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

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

		
	
}
