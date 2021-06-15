package com.qa.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.library.domain.Book;
import com.qa.library.dto.BooksDTO;
import com.qa.library.repo.BooksRepo;
import com.qa.library.utils.BooksMapper;


@Service
public class BooksService {

	private BooksRepo repo;
	
	private BooksMapper mapper;

	@Autowired
	public BooksService(BooksRepo repo, BooksMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	
	// FUNCTION TO CREATE BOOKS
	public BooksDTO saveBook(Book book) {
		Book saved = this.repo.save(book);
		return this.mapper.mapToDTO(saved);
		
	}
	

	// FUNCTION TO READ ALL BOOKS
	public List<BooksDTO> readAll() {
		List<Book> bookCollection = this.repo.findAll();
		List<BooksDTO> dtos = new ArrayList<>();
		
		BooksDTO dto = null;
		for (Book book1 : bookCollection) {
			dto = this.mapper.mapToDTO(book1);
			dtos.add(dto);
		}
		return dtos;
	}
	
	
	//	FUNCTION TO FIND BY ID
	public BooksDTO findBook(Integer bookID) {
		Optional<Book> optionalBook = this.repo.findById(bookID);
		Book found =  optionalBook.orElseThrow(() -> new EntityNotFoundException());
			return this.mapper.mapToDTO(found);			
	}
	
	//	FUNCTION UPDATE BOOKS
	public BooksDTO updateBook(Integer bookID, Book book) {
		Book exists = this.repo.findById(bookID).orElseThrow(() -> new EntityNotFoundException()); //  GETS EXISTING DATA
		
		exists.setName(book.getName()); // UPDATES EXISTING DATA
		exists.setAuthor(book.getAuthor());
		
		
		Book updated = this.repo.save(exists); // UPDATES EXISTING DATA
		
		return this.mapper.mapToDTO(updated); // RETURNS THE UPDATED DATA
	}
	
	
	//	FUNCTION TO DELETE BOOKS BY ID
	public boolean deleteBook(Integer bookID) {
		this.repo.deleteById(bookID);
		return !this.repo.existsById(bookID);
	}
	
	
}
