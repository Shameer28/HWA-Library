package com.qa.library.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.library.domain.Books;
import com.qa.library.domain.Library;
import com.qa.library.dto.BooksDTO;
import com.qa.library.dto.LibraryDTO;

@Service
public class LibraryMapper implements Mapper<Library, LibraryDTO>  {

	private BooksMapper booksMapper;

	@Override
	public LibraryDTO mapToDTO(Library entity) {
		
		LibraryDTO dto = new LibraryDTO();
		dto.setLibID(entity.getLibID());
		dto.setName(entity.getName());
		List<BooksDTO> books = new ArrayList<>();
		for (Books book : entity.getBook()) {
			books.add(this.booksMapper.mapToDTO(book));
		}
			
		dto.setBook(books);
		return dto;
	}

	@Override
	public Library mapFromDTO(LibraryDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


