package com.qa.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.library.domain.Library;
import com.qa.library.repo.LibraryRepo;

@Service
public class LibraryService {

	private LibraryRepo repo;
	
	@Autowired
	public LibraryService(LibraryRepo repo) {
		super();
		this.repo = repo;
	}
	
	//	FUNCTION TO CREATE LIBRARY
	public Library saveLibrary (Library library) {
		return this.repo.save(library);
	}
	
	
	// FUNCTION TO READ ALL LIBRARIES 
	public List<Library> readAll(){
		return this.repo.findAll();
	}
		
	
	// FUNCTION TO FIND BY ID
	public Library findLibrary(Integer libID) {
		Optional<Library> lib = this.repo.findById(libID);
			return lib.get();			
	}
	
		
	// FUNCTION TO UPDATE LIBRARY
	public Library updateLibrary(Integer libID, Library library) {
		Library exists = this.findLibrary(libID); // GETS EXISTING DATA
			
		exists.setName(library.getName()); // UPDATES EXISTING DATA
			
		Library updated = this.repo.save(exists); // OVERWRITES THE EXISTING DATA
			
		return updated; // RETURNS THE UPDATED DATA
	}
		
		
	// FUNCTION TO DELETE LIBRARY BY ID
	public boolean deleteLibrary (Integer libID) {
		this.repo.deleteById(libID);
		return !this.repo.existsById(libID);
	}
	
	
	
}
