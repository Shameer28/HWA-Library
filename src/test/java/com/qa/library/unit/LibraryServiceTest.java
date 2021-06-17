package com.qa.library.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.library.domain.Library;
import com.qa.library.dto.LibraryDTO;
import com.qa.library.repo.LibraryRepo;
import com.qa.library.service.LibraryService;

@SpringBootTest
@ActiveProfiles("test")
public class LibraryServiceTest {
	
	@Autowired
	private LibraryService service;
	
	@MockBean
	private LibraryRepo repo;
	
	
	
	@Test
	void testSaveLibrary() {
		int testId = 1;
		Library testData = new Library(testId, "Birch");
		LibraryDTO libraryDTO = this.service.mapper.mapToDTO(testData);


		Mockito.when(this.repo.save(testData)).thenReturn(testData);
		
		assertThat(this.service.saveLibrary(testData)).isEqualTo(libraryDTO);
	}
	
	
	@Test
	void testReadAll() {
		Library library = new Library(1, "QA");
		List<Library> libraries = List.of(library);
		List<LibraryDTO> totalLibraries = List.of(this.service.mapper.mapToDTO(library));
		
		Mockito.when(this.repo.save(library)).thenReturn(library);
	
		Mockito.when(this.repo.findAll()).thenReturn(libraries);
		
		assertThat(this.service.readAll()).isEqualTo(totalLibraries);
	}
	
	
	@Test
	void testUpdateLibrary() {
		// GIVEN
		Library existing = new Library(1, "QA");
		Library updated = new Library(1, "QAC");
		LibraryDTO updatedLibraryDTO = new LibraryDTO(1, "QAC", new ArrayList<>());
	

		// WHEN
		Mockito.when(this.repo.findById(1)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(updated)).thenReturn(updated);
		
		assertThat(this.service.updateLibrary(1, updated)).isEqualTo(updatedLibraryDTO);
		
	}
	
	
	@Test
	void testDeleteLibrary() {
		// GIVEN
		Integer testId = 1;
		boolean exists = false;
		// WHEN
		Mockito.when(this.repo.existsById(testId)).thenReturn(exists);

		// THEN
		assertThat(this.service.deleteLibrary(testId)).isEqualTo(!exists);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(testId);
		
	}
}
