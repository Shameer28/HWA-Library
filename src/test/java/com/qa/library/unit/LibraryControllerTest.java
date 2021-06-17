package com.qa.library.unit;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.library.LibraryProjectApplication;
import com.qa.library.domain.Library;
import com.qa.library.dto.LibraryDTO;
import com.qa.library.rest.LibraryController;
import com.qa.library.service.LibraryService;

@SpringBootTest(classes = LibraryProjectApplication.class)
@ActiveProfiles("test")
public class LibraryControllerTest {
	

	@Autowired
	private LibraryController controller;
	
	@MockBean
	private LibraryService service;
	
	
	@Test
	void testSaveLibrary() throws Exception {
		//GIVEN
		
		Library testLibrary = new Library("birch");
        
		LibraryDTO dtos = new LibraryDTO(2, "QAC");
		
		
		Mockito.when(service.saveLibrary(testLibrary)).thenReturn(dtos);
		
		assertThat(this.controller.saveLibrary(testLibrary)).isEqualTo(dtos);
		
		Mockito.verify(this.service, Mockito.times(1)).saveLibrary(testLibrary);


	}
	
	@Test
	void testReadAll() {
		LibraryDTO LibraryDTO = new LibraryDTO(1, "birch");
		List<LibraryDTO> dtos = List.of(LibraryDTO);	
		
		// WHEN
		Mockito.when(this.service.readAll()).thenReturn(dtos);
		
		// THEN
		assertThat(this.controller.readAll()).isEqualTo(dtos);
		
		Mockito.verify(this.service, Mockito.times(1)).readAll();
		
	}
	
	@Test
	void testFindLibrary() {
		int testId = 1;
		LibraryDTO dto = new LibraryDTO(1, "QAC");

		// WHEN
		Mockito.when(this.service.find(testId)).thenReturn(dto);

		// THEN
		assertThat(this.controller.findLibrary(testId)).isEqualTo(dto);
		
		
		
	}
	
	@Test
	void testUpdateLibrary() {
		Integer testId = 1;
		Library testLibrary = new Library(1, "QAC");
		Library updatedLibrary = new Library(testId, "QAC");
		LibraryDTO updatedLibraryDTO = new LibraryDTO(testId, "QAC");
	
		//WHEN
		Mockito.when(this.service.updateLibrary(testId, testLibrary)).thenReturn(updatedLibraryDTO);
		
		// THEN
		assertThat(this.controller.updateLibrary(testId, testLibrary)).isEqualTo(updatedLibraryDTO);
	
		Mockito.verify(this.service, Mockito.times(1)).updateLibrary(testId, updatedLibrary);
		
	}
	
	@Test
	void testDeleteLibrary() {
		// GIVEN
		Integer testId = 1;
		
		// WHEN
		Mockito.when(this.service.deleteLibrary(testId)).thenReturn(true);

		// THEN
		assertThat(this.controller.deleteLibrary(testId)).isEqualTo(true);

		
		Mockito.verify(this.service, Mockito.times(1)).deleteLibrary(testId);
		
	}
}
