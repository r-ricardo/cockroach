package com.test;

import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book findById(long isbn) {
		return bookRepository
				.findById(isbn)
				.orElseThrow(
						() -> new HttpNotFoundException(String.format("Book with ISBN:[%d] not found", isbn))
						);
	}
}
