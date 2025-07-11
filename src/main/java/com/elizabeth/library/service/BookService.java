package com.elizabeth.library.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.elizabeth.library.model.Book;
import com.elizabeth.library.model.Library;

@Service
public class BookService{
;
    private final Library library;

    // constructor
    public BookService(Library library){
        this.library = library;
    }

    // find all books
    public List<Book> findBooks(){
        return library.getBooks();
    }

    // find book by id
    public Optional<Book> findBookById(String id){
        // check if id matches any book 
        return library.getBooks().stream()
                                .filter(b -> b.getID().equals(id)).findFirst();
    }

    // save book
    public Book saveBook(Book book){
        library.getBooks().add(book);
        return book;
    }

    // update book
    public Optional<Book> updateBook(String id, Book book){
        // find book by id functin
        Optional<Book> searchingBook = findBookById(id);
        // check if function returned null or not
        if(searchingBook.isPresent()){
            // use setters
            Book existingBook = searchingBook.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setAvailability(book.getAvailability());
            return Optional.of(existingBook);
        }
        // return book
        return Optional.empty();
    }

    // delete book
    public boolean deleteBook(String id){
        return library.getBooks().removeIf(b -> b.getID().equals(id));
    }

    // search for book
    public List<Book> search(String author, String title){
        return library.getBooks().stream().filter(b -> (b.getAuthor().equalsIgnoreCase(author)) && (b.getTitle().equalsIgnoreCase(title))).collect(Collectors.toList());
    }
}