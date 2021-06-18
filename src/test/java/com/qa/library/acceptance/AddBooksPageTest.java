package com.qa.library.acceptance;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.qa.library.LibraryProjectApplication;

@SpringBootTest(classes = LibraryProjectApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AddBooksPageTest {

}
