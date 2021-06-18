package com.qa.library.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.library.LibraryProjectApplication;
import com.qa.library.domain.Book;
import com.qa.library.dto.BooksDTO;
import com.qa.library.repo.BooksRepo;

@SpringBootTest(classes = LibraryProjectApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:Library-schema.sql","classpath:Library-data.sql"}, 
executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class BookIntegrationTest {

	@Autowired	
	private MockMvc mvc; // allows us to send mock requests

	@Autowired
	private ObjectMapper mapper;
	
    @Autowired
    private BooksRepo repo;
    
    
	//CREATE
	@Test
	void testSaveBook() throws Exception {
		Book testBook = new Book("Macbeth", "Shakesphere");
		String testBookAsJSON = this.mapper.writeValueAsString(testBook);
		
		BooksDTO testBookDTO = new BooksDTO(2,"Macbeth", "Shakesphere");
		String testDTOAsJSON = this.mapper.writeValueAsString(testBookDTO);
		
		
		RequestBuilder mockRequest = post("/books/create").content(testBookAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(testDTOAsJSON);

		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
  
	}  
	
	
	//READ
	@Test
	void testReadAll() throws Exception {
		BooksDTO testBook = new BooksDTO(1, "Romeo & Julliet", "JK Rowling");
		List<BooksDTO> testBooks = List.of(testBook);
		String testBooksAsJSONArray = this.mapper.writeValueAsString(testBooks);

		this.mvc.perform(get("/books")).andExpect(status().isOk()).andExpect(content().json(testBooksAsJSONArray));
		
		}  

	
	//UPDATE
	@Test
	void testUpdateBook() throws Exception{
		 Book updateBook = new Book(1 ,"Romeo & Julliet", "JK Rowling");
	        String updateBookAsJSON = this.mapper.writeValueAsString(updateBook);
	        
	        BooksDTO bookDTO = new BooksDTO(1, "Romeo & Julliet", "JK Rowling");
	        String dtoAsJSON = this.mapper.writeValueAsString(bookDTO);
	        
	        
	        
	        this.mvc.perform(put("/books/update/1").content(updateBookAsJSON).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().json(dtoAsJSON));
	        
	    }
		
	
	
	//DELETE
	@Test
	void testDeleteBook() throws Exception {
        assertThat(repo.existsById(1));
        this.mvc.perform(delete("/books/remove/1")).andExpect(status().isOk());
        assertThat(!(repo.existsById(1)));
    }
    
 		
		
	}
	
	
	

