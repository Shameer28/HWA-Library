package com.qa.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.library.domain.Books;
import com.qa.library.repo.BooksRepo;


@Service
public class BooksService {

	private BooksRepo repo;

	@Autowired
	public BooksService(BooksRepo repo) {
		super();
		this.repo = repo;
	}
	
	// FUNCTION TO CREATE BOOKS
	public Books saveBook(Books books) {
		return this.repo.save(books);
		
	}
	
	// FUNCTION TO READ ALL BOOKS
	public List <Books> readAll() {
		return this.repo.findAll();
	}
	
	
	//	FUNCTION TO FIND BY ID
	public Books findBook(Integer bookID) {
		Optional<Books> book = this.repo.findById(bookID);
			return book.get();			
	}
	
	//	FUNCTION UPDATE BOOKS
	public Books updateBook(Integer bookID, Books books) {
		Books exists = this.findBook(bookID); // GETS EXISTING DATA
		
		exists.setName(books.getName()); // UPDATES EXISTING DATA
		exists.setAuthor(books.getAuthor());
		
		
		Books updated = this.repo.save(exists); // UPDATES EXISTING DATA
		
		return updated; // RETURNS THE UPDATED DATA
	}
	
	
	//	FUNCTION TO DELETE BOOKS BY ID
	public boolean deleteBook(Integer bookID) {
		this.repo.deleteById(bookID);
		return !this.repo.existsById(bookID);
	}
	
	
}
