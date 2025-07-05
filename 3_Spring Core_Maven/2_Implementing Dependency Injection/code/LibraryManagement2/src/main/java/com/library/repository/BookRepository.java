package com.library.repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class BookRepository {
	
	public void saveBookToDB(String bookName) {
		final Logger logger=LoggerFactory.getLogger("BookRepository.java");
		logger.info("{}: Book saved to database",bookName);
	}
}
