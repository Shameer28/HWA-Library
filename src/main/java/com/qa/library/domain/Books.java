package com.qa.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Books {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //AUTO INCREMENT
	private Integer bookID;
	
	@Column
	private String name;
	
	@Column String author;
	
	@ManyToOne
	private Library library;

	
	
	@Override
	public String toString() {
		return "Books [bookID= " + bookID + ", name= " + name + ", author= " + author + ", library= " + library + "]";
	}
	
	
	//	CONSTRUCTOR CRUD
	public Books() {
		super();
	}
	
	
	//	CONSTRUCTOR
	public Books(String name, String author, Library library) {
		super();
		this.name = name;
		this.author = author;
		this.library = library;
	}

	
	//	CONSTRUCTOR
	public Books(Integer bookID, String name, String author, Library library) {
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

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
		result = prime * result + ((library == null) ? 0 : library.hashCode());
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
		Books other = (Books) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookID == null) {
			if (other.bookID != null)
				return false;
		} else if (!bookID.equals(other.bookID))
			return false;
		if (library == null) {
			if (other.library != null)
				return false;
		} else if (!library.equals(other.library))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

	
}
