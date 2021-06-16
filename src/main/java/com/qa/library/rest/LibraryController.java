package com.qa.library.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.library.domain.Library;
import com.qa.library.dto.LibraryDTO;
import com.qa.library.service.LibraryService;

@RestController
public class LibraryController {

	private LibraryService service;

	
	@Autowired //INJECTING THE SERVICE CLASS
	public LibraryController(LibraryService service) {
		super();
		this.service = service;
	}
	
	
	@PostMapping("/library/create") // CREATE
	public LibraryDTO saveLibrary(@RequestBody Library library) {
		return this.service.saveLibrary(library);
	}
	
	
	@GetMapping("/library") // READ
	public List<LibraryDTO> readAll() {
		return this.service.readAll();
	}
	
	
	@GetMapping("/library/findId/{libID}")
	public LibraryDTO findLibrary(@PathVariable Integer libID) {
		return this.service.find(libID);
	}
	
	
	@PutMapping("/library/update/{libID}") // UPDATE
	public LibraryDTO updateLibrary(@PathVariable Integer libID, @RequestBody Library library) {
		return this.service.updateLibrary(libID, library);
	}
	
	
	@DeleteMapping("/library/remove/{libID}") // DELETE
	public boolean deleteLibrary(@PathVariable Integer libID) {
		return this.service.deleteLibrary(libID);
	}
	
	
}