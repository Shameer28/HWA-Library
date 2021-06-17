package com.qa.library.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.qa.library.domain.Library;
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
		Library testLibrary = new Library("Birch Library");
		String testLibraryAsJSON = this.mapper.writeValueAsString(testLibrary);

		Library testSavedLibrary = new Library("Birch Library");
		testSavedLibrary.setLibID(2);
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
		Library testLibrary = new Library("Birch Library");
		List<Library> testLibrarys = List.of(testLibrary);
		String testLibrarysAsJSONArray = this.mapper.writeValueAsString(testLibrarys);

		this.mvc.perform(get("/library")).andExpect(status().isOk()).andExpect(content().json(testLibrarysAsJSONArray));

		
		
	}
	
	
	@Test
	void testFindLibrary() throws Exception {
		
		
		
	}
	
	//UPDATE
	@Test
	void testUpdateLibrary() throws Exception {
		Library testLibrary = new Library("Birch Library");
		String testLibraryAsJSON = this.mapper.writeValueAsString(testLibrary);

		Library testSavedLibrary = new Library("Birch Library");
		testSavedLibrary.setLibID(2);
		String testSavedLibraryAsJSON = this.mapper.writeValueAsString(testSavedLibrary);
 
		RequestBuilder mockRequest = post("/library/create").content(testLibraryAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(testSavedLibraryAsJSON);

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
