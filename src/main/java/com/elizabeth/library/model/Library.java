package com.elizabeth.library.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Library{
    private List<Book> books;
    private Map<User,List<Book>> bookDB;

    public Library(){
        this.books = new ArrayList<>();
        this.bookDB = new HashMap<>();
        initializeSampleLibrary();
    }

    // constructor
    public Library(List<Book> books, Map<User, List<Book>> bookDB){
        this.books = (books != null) ? books : new ArrayList<>();
        this.bookDB = (bookDB != null) ? bookDB : new HashMap<>();
    }

    // accessor
    public List<Book> getBooks(){
        return books;
    }

    public Map<User, List<Book>> getBookDB(){
        return bookDB;
    }

    // mutator
    public void setBooks(List<Book> newBooks){
        this.books = newBooks;
    }
    
    public void setBookDB(Map<User, List<Book>> newEntry){
        this.bookDB = newEntry;
    }

    private void initializeSampleLibrary(){
        this.books.add(new Book("To Kill a Mockingbird", "Harper Lee", true));
        this.books.add(new Book("1984", "George Orwell", true));
        this.books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", true));
        this.books.add(new Book("Pride and Prejudice", "Jane Austen", true));
        this.books.add(new Book("The Hobbit", "J.R.R. Tolkien", true));
        this.books.add(new Book("The Catcher in the Rye", "J.D. Salinger", true));
        this.books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", true));
        this.books.add(new Book("Harry Potter and the Sorcerers Stone", "J.K. Rowling", true));
        this.books.add(new Book("The Chronicles of Narnia", "C.S. Lewis", true));
        this.books.add(new Book("Frankenstein", "Mary Shelley", true));
    }
}