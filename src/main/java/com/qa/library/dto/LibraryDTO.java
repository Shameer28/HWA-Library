package com.qa.library.dto;

import java.util.List;

public class LibraryDTO {
	
	private Integer libID;
	
	private String name;
	
	private List<BooksDTO> book;

	
	
	public LibraryDTO(Integer libID, String name) {
		super();
		this.libID = libID;
		this.name = name;
	}


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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((libID == null) ? 0 : libID.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryDTO other = (LibraryDTO) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (libID == null) {
			if (other.libID != null)
				return false;
		} else if (!libID.equals(other.libID))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}