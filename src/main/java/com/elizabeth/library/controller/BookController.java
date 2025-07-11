package com.elizabeth.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elizabeth.library.model.Book;
import com.elizabeth.library.service.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController{
    // fields
    private final BookService bookService;

    // constructor
    public BookController(BookService bookservice){
        this.bookService = bookservice;        
    }

    // GET request for retrieving books
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.findBooks();
    }

    // GET request for retrieving specific book by id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id){
        Optional<Book> book = bookService.findBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // POST request for adding a book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book){
        Optional<Book> updated = bookService.updateBook(id, book);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE requests to delete a book
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(
        @RequestParam(required = false) String title, 
        @RequestParam(required = false) String author) {
        return bookService.search(title, author);
    }

}