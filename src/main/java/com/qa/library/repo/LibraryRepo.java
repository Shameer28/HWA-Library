package com.qa.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.library.domain.Library;

public interface LibraryRepo extends JpaRepository<Library, Integer>{
	
}