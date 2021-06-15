package com.qa.library.utils;

import org.springframework.stereotype.Service;

import com.qa.library.domain.Books;
import com.qa.library.dto.BooksDTO;

@Service
public class BooksMapper implements Mapper<Books, BooksDTO> {

	@Override
	public BooksDTO mapToDTO(Books books) {
		BooksDTO dto = new BooksDTO();
		
		dto.setBookID(books.getBookID());
		dto.setAuthor(books.getAuthor());
		dto.setName(books.getName());
		
		return dto;
		
	}

	@Override
	public Books mapFromDTO(BooksDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
