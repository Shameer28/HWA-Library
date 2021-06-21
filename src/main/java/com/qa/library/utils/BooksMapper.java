package com.qa.library.utils;

import org.springframework.stereotype.Service;

import com.qa.library.domain.Book;
import com.qa.library.dto.BooksDTO;

@Service
public class BooksMapper implements Mapper<Book, BooksDTO> {

	@Override
	public BooksDTO mapToDTO(Book book) {
		BooksDTO dto = new BooksDTO();
		
		dto.setBookID(book.getBookID());
		dto.setAuthor(book.getAuthor());
		dto.setName(book.getName());
		
		return dto;
		
	}

	@Override
	public Book mapFromDTO(BooksDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
