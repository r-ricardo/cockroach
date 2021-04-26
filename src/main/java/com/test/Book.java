package com.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long isbn;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "num_pages")
	private int numPages;
	
	public Book() {}
	
	public Book(long isbn, String title, int numPages) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.numPages = numPages;
	}

	public long getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public int getNumPages() {
		return numPages;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", numPages=" + numPages + "]";
	}
}
