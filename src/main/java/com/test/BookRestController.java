package com.test;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequestMapping("/books")
@RestController
public class BookRestController {

	private final static Logger log = LoggerFactory.getLogger(BookRestController.class);
	
	private BookService bookService;
	
	@Autowired
	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createNewBook(@RequestBody Book requestBook) {
		log.info("New book request to be saved {}", requestBook);
		
		Book book = bookService.save(requestBook);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{isbn}")
				.build(book.getIsbn());
		
		log.info("Book successfuly saved at {}", location.toString());
		return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.location(location).build();
	}
	
	@GetMapping(path = "/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBook(@PathVariable long isbn) {
		log.info("Book with ISBN:[{}] requested");
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bookService.findById(isbn));
	}
}
