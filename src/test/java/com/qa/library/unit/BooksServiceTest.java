package com.qa.library.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.library.LibraryProjectApplication;
import com.qa.library.domain.Book;
import com.qa.library.dto.BooksDTO;
import com.qa.library.repo.BooksRepo;
import com.qa.library.service.BooksService;

@SpringBootTest(classes = LibraryProjectApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class BooksServiceTest {

	@Autowired
	private BooksService service;
	
	@MockBean
	private BooksRepo repo;
	
	
	@Test
	void testSaveBook() {
	//GIVEN
	Book testBook = new Book("Macbeth", "Shakesphere");
	Book existing = new Book (2, "Macbeth", "Shakesphere");
	BooksDTO testBookDTO = new BooksDTO(2, "Macbeth", "Shakesphere");
	
	//WHEN
	Mockito.when(this.repo.save(testBook)).thenReturn(existing);
	
	//THEN
	assertThat(this.service.saveBook(testBook)).isEqualTo(testBookDTO);
	
	Mockito.verify(this.repo, Mockito.times(1)).save(testBook);
	}
	
	
	@Test
	void testReadAll() {
	//Given
	Book book = new Book(2, "Macbeth", "Shakesphere");
	List<Book> books = List.of(book);
	
	BooksDTO bookDTO = new BooksDTO(2, "Macbeth", "Shakesphere");
	List<BooksDTO> dtos = List.of(bookDTO);
	
	//WHEN
	Mockito.when(this.repo.findAll()).thenReturn(books);
	
	//THEN
	assertThat(this.service.readAll()).isEqualTo(dtos);
	
	}
	
	
	@Test
	void testUpdateBook() {
	// GIVEN
	Integer testId = 1;
	Book testBook = new Book("Can't Touch this", "MC Hammer");
	Book existing = new Book(1, null, null);
	Book updatedBook = new Book(testId, "Can't Touch this", "MC Hammer");
	BooksDTO updatedBookDTO = new BooksDTO(testId, "Can't Touch this", "MC Hammer");
		
	

	// WHEN
	Mockito.when(this.repo.findById(testId)).thenReturn(Optional.of(existing));
	Mockito.when(this.repo.save(updatedBook)).thenReturn(updatedBook);

	// THEN
	assertThat(this.service.updateBook(testId, testBook)).isEqualTo(updatedBookDTO);

	Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
	Mockito.verify(this.repo, Mockito.times(1)).save(updatedBook);
		
	}
	
	
	@Test
	void testDeleteBook() {
	// GIVEN
	Integer testId = 1;
	boolean exists = false;
	// WHEN
	Mockito.when(this.repo.existsById(testId)).thenReturn(exists);

	// THEN
	assertThat(this.service.deleteBook(testId)).isEqualTo(!exists);

	Mockito.verify(this.repo, Mockito.times(1)).existsById(testId);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
