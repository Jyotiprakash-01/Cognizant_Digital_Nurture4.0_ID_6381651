package com.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.library.repository.BookRepository;

public class BookService {
	private static final Logger logger=LoggerFactory.getLogger("BookService.java");
	private BookRepository bookRepository;
	
	//A setter based dependency is created between book service and book repository
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	
	public void addBook(String bookName) {
		logger.info("Added Book {}",bookName);
		bookRepository.saveBookToDB(bookName);
		
	}
	


}
