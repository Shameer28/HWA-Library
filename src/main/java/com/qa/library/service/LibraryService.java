package com.qa.library.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.library.domain.Library;
import com.qa.library.dto.LibraryDTO;
import com.qa.library.repo.LibraryRepo;
import com.qa.library.utils.LibraryMapper;

@Service
public class LibraryService {

	private LibraryRepo repo;
	
	public LibraryMapper mapper;
	
	@Autowired
	public LibraryService(LibraryRepo repo, LibraryMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	
	//	FUNCTION TO CREATE LIBRARY
	public LibraryDTO saveLibrary (Library library) {
		Library saved = this.repo.save(library);
		return this.mapper.mapToDTO(saved);
	}
	
	
	// FUNCTION TO READ ALL LIBRARIES 
	public List<LibraryDTO> readAll(){
		List<Library> libs = this.repo.findAll();
		
		List <LibraryDTO> dtos = new ArrayList<>();
		
		for(Library lib : libs) {
			LibraryDTO dto = this.mapper.mapToDTO(lib);
			dtos.add(dto);
		}
		
		return dtos;
	}
		
	
	// FUNCTION TO FIND BY ID
	public LibraryDTO find(Integer libID) {
		Library found = this.repo.findById(libID).orElseThrow(() -> new EntityNotFoundException());
			return this.mapper.mapToDTO(found);		
	}
	
		
	// FUNCTION TO UPDATE LIBRARY
	public LibraryDTO updateLibrary(Integer libID, Library library) {
		Library exists = this.repo.findById(libID).orElseThrow(() -> new EntityNotFoundException()); // GETS EXISTING DATA
			
		exists.setName(library.getName()); // UPDATES EXISTING DATA
			
		Library updated = this.repo.save(exists); // OVERWRITES THE EXISTING DATA
			
		return this.mapper.mapToDTO(updated); // RETURNS THE UPDATED DATA
	}
	
		
	// FUNCTION TO DELETE LIBRARY BY ID
	public boolean deleteLibrary (Integer libID) {
		this.repo.deleteById(libID);
		return !this.repo.existsById(libID);
	}
	
	
}
