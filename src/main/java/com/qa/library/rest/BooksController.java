package com.qa.library.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.library.domain.Book;
import com.qa.library.dto.BooksDTO;
import com.qa.library.service.BooksService;

@RestController
public class BooksController {

	private BooksService service;

	@Autowired // INJECTING THE SERVICE CLASS
	public BooksController(BooksService service) {
		super();
		this.service = service;
	}
	
	
	@PostMapping("/books/create") // CREATE
	public BooksDTO savebook(@RequestBody Book book) {
		return this.service.saveBook(book);
	}
	
	
	@GetMapping("/books") // READ
	public List<BooksDTO> readAll() {
		return this.service.readAll();
	}
	
	
	@GetMapping("/books/findId/{bookID}")
	public BooksDTO findBook(Integer bookID) {
		return this.service.findBook(bookID);
	}
	
	
	@PutMapping("/books/update/{bookID}") // UPDATE
	public BooksDTO updateBook(@PathVariable Integer bookID, @RequestBody Book book) {
		return this.service.updateBook(bookID, book);
	}
	
	
	@DeleteMapping("/books/remove/{bookID}") // DELETE
	public boolean deleteBook(@PathVariable Integer bookID) {
		return this.service.deleteBook(bookID);
	}
	
	

}