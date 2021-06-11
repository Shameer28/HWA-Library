package com.qa.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.qa.library.domain.Books;

public interface BooksRepo extends JpaRepository<Books, Integer>{

	
	
}