package com.qa.library.dto;

public class BooksDTO {
	
	private Integer bookID;
	
	
	private String name;
	
	
	private String author;
	
	
	
	
	public BooksDTO(Integer bookID, String name, String author) {
		super();
		this.bookID = bookID;
		this.name = name;
		this.author = author;
	}


	//	CONSTRUCTOR CRUD
	public BooksDTO() {
		
	}
	
	
//	//	CONSTRUCTOR
//	public BooksDTO(String name, String author, Library library) {
//		super();
//		this.name = name;
//		this.author = author;
//	}
//
//	
//	//	CONSTRUCTOR
//	public BooksDTO(Integer bookID, String name, String author, Library library) {
//		super();
//		this.bookID = bookID;
//		this.name = name;
//		this.author = author;
//	
//	}

	
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


//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((author == null) ? 0 : author.hashCode());
//		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BooksDTO other = (BooksDTO) obj;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
