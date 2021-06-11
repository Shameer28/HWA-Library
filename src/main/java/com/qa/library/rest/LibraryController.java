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
import com.qa.library.service.LibraryService;

@RestController
public class LibraryController {

	private LibraryService service;

	
	@Autowired //INJECTING THE SERVICE CLASS
	public LibraryController(LibraryService service) {
		super();
		this.service = service;
	}
	
	
	@PostMapping("/create") // CREATE
	public Library saveLibrary(@RequestBody Library library) {
		return this.service.saveLibrary(library);
	}
	
	
	@GetMapping("/") // READ
	public List<Library> readAll() {
		return this.service.readAll();
	}
	
	
	@GetMapping("/findId/{id}")
	public Library findLibrary(@PathVariable Integer libID) {
		return this.service.findLibrary(libID);
	}
	
	
	@PutMapping("/update/{id}") // UPDATE
	public Library updateLibrary(@PathVariable Integer libID, @RequestBody Library library) {
		this.service.findLibrary(libID);
		return this.service.updateLibrary(libID, library);
	}
	
	
	@DeleteMapping("delete/{id}") // DELETE
	public boolean deleteLibrary(@PathVariable Integer libID) {
		return this.service.deleteLibrary(libID);
	}
	

	
}