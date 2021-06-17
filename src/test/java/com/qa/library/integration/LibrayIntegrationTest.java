package com.qa.library.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
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
import com.qa.library.domain.Library;
import com.qa.library.dto.BooksDTO;
import com.qa.library.dto.LibraryDTO;
import com.qa.library.repo.LibraryRepo;

@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:Library-schema.sql","classpath:Library-data.sql"},
		executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class LibrayIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private LibraryRepo repo;
	
	//CREATE  
	@Test
	void testSaveLibrary() throws Exception {
		
		Library testLibrary = new Library("QAC Library");
		String testLibraryAsJSON = this.mapper.writeValueAsString(testLibrary);

		LibraryDTO testSavedLibrary = new LibraryDTO(2, "QAC Library", new ArrayList<>());
		
		String testSavedLibraryAsJSON = this.mapper.writeValueAsString(testSavedLibrary);
 
		RequestBuilder mockRequest = post("/library/create").content(testLibraryAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(testSavedLibraryAsJSON);

		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
 
	}  

	
	//READ
	@Test
	void testReadAll() throws Exception {
		
		BooksDTO testBook = new BooksDTO(1, "Romeo & Julliet", "JK Rowling");
		List<BooksDTO> testBooks = List.of(testBook);
		
		LibraryDTO testLibrary = new LibraryDTO(1, "Birch Library", testBooks);
		
		List<LibraryDTO> testLibrarys = List.of(testLibrary);
		
		String testLibrarysAsJSONArray = this.mapper.writeValueAsString(testLibrarys);

		this.mvc.perform(get("/library")).andExpect(status().isOk()).andExpect(content().json(testLibrarysAsJSONArray));

		
	}
	
	@Test
	void testFindLibrary() throws Exception {
		
		BooksDTO testBook = new BooksDTO(1, "Romeo & Julliet", "JK Rowling");
		List<BooksDTO> testBooks = List.of(testBook);
		
		LibraryDTO testLibrary = new LibraryDTO(1, "Birch Library", testBooks);
		
		String testLibrarysAsJSON = this.mapper.writeValueAsString(testLibrary);
 
		this.mvc.perform(get("/library/findId/1")).andExpect(status().isOk()).andExpect(content().json(testLibrarysAsJSON));
		
	}
	
		
	//UPDATE
	@Test
	void testUpdateLibrary() throws Exception {
		
		BooksDTO testBook = new BooksDTO(1, "Romeo & Julliet", "JK Rowling");
		List<BooksDTO> testBooks = List.of(testBook);
		
		Library testLibrary = new Library("Birch Library");
		String testLibraryAsJSON = this.mapper.writeValueAsString(testLibrary);
 
		LibraryDTO testSavedLibrary = new LibraryDTO(1, "Birch Library", testBooks);
		String testSavedLibraryAsJSONArray = this.mapper.writeValueAsString(testSavedLibrary);
 
		RequestBuilder mockRequest = put("/library/update/1").content(testLibraryAsJSON)
				.contentType(MediaType.APPLICATION_JSON); 

		ResultMatcher checkStatus = status().isOk(); 

		ResultMatcher checkBody = content().json(testSavedLibraryAsJSONArray);

		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);	
		
	}
	
	//DELETE
	@Test
	void testDeleteLibrary() throws Exception {
		assertThat(repo.existsById(1));
	    this.mvc.perform(delete("/library/remove/1")).andExpect(status().isOk());
	    assertThat(!(repo.existsById(1)));
	    }
	
}
