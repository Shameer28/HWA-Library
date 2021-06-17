package com.qa.library.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.library.domain.Book;
import com.qa.library.dto.BooksDTO;
import com.qa.library.rest.BooksController;
import com.qa.library.service.BooksService;

@SpringBootTest
@ActiveProfiles("test")
public class BooksControllerTest {
	
	@Autowired
	private BooksController controller;

	@MockBean
	private BooksService service;

	@Test
	void testSaveBook () {
		// GIVEN
		Book testBook = new Book("Chaos", "Shameer");
		BooksDTO createdDTO = new BooksDTO(2, "Chaos", "Shameer");
		
		// WHEN
		Mockito.when(service.saveBook(testBook)).thenReturn(createdDTO);
		
		assertThat(this.controller.savebook(testBook)).isEqualTo(createdDTO);

		Mockito.verify(this.service, Mockito.times(1)).saveBook(testBook);
	}
	
	
	@Test
	void testReadAll() {
		BooksDTO bookDTO = new BooksDTO(1, "Chaos", "Alin");
		List<BooksDTO> dtos = List.of(bookDTO);	
		
		// WHEN
		Mockito.when(this.service.readAll()).thenReturn(dtos);
		
		// THEN
		assertThat(this.controller.readAll()).isEqualTo(dtos);
		
		Mockito.verify(this.service, Mockito.times(1)).readAll();
		
	}
	
	@Test
	void testUpdateBook() {
		// GIVEN
		Integer testId = 1;
		Book testBook = new Book(1, "QAC", "Harris");
		Book updatedBook = new Book(testId, "QAC", "Harris");
		BooksDTO updatedBookDTO = new BooksDTO(testId, "QAC", "Harris");
	
		//WHEN
		Mockito.when(this.service.updateBook(testId, testBook)).thenReturn(updatedBookDTO);
		
		// THEN
		assertThat(this.controller.updateBook(testId, testBook)).isEqualTo(updatedBookDTO);
	
		Mockito.verify(this.service, Mockito.times(1)).updateBook(testId, updatedBook);
		
	}
	
	@Test 
	void testDeleteBook() {
		// GIVEN
		Integer testId = 1;
				
		// WHEN
		Mockito.when(this.service.deleteBook(testId)).thenReturn(true);

		// THEN
		assertThat(this.controller.deleteBook(testId)).isEqualTo(true);

		Mockito.verify(this.service, Mockito.times(1)).deleteBook(testId);
		
	}
	
}
