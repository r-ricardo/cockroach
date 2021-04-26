package com.test;

public interface BookService {

	Book save(Book book);
	Book findById(long isbn);
}
