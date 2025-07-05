package com.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.library.repository.BookRepository;

public class BookService {
	private static final Logger logger=LoggerFactory.getLogger("BookService.java");
	private BookRepository bookRepository;
	
/*No setter dependencies is there between the beans so bookRepository
Will be initialized to null and we might get an null pointer exception
thrown when we run this maven application.
*/
	
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	
	public void addBook(String bookName) {
		logger.info("Added Book {}",bookName);
		bookRepository.saveBookToDB(bookName);
		
	}
	


}
