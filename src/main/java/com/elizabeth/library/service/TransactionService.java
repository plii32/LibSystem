package com.elizabeth.library.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elizabeth.library.model.Book;
import com.elizabeth.library.model.Library;
import com.elizabeth.library.model.User;

@Service
public class TransactionService{
    // fields
    private final Library library;
    private final BookService bookService;
    private final UserService userService;

    // constructor
    public TransactionService(Library library, BookService bookService, UserService userService){
        this.library = library;
        this.bookService = bookService;
        this.userService = userService;
    }

    // borrow
    public String borrowBook(String id, String bookId){
        Optional<User> user = userService.findUser(id);
        Optional<Book> book = bookService.findBookById(id);

        // determine if user and book exists
        if(user.isEmpty()){
            throw new IllegalArgumentException("User ID " + id + " not found.");
        }
        if(book.isEmpty()){
            throw new IllegalArgumentException("Book ID " + bookId + " not found.");
        }

        User existingUser = user.get();
        Book existingBook = book.get();

        // check if book is available
        if(existingBook.getAvailability()){
            // set book availability to false
            existingBook.setAvailability(false);
            // add book to users borrowed list
            existingUser.getBorrowedList().add(existingBook);
            // put user entry in bookdb
            library.getBookDB().put(existingUser, existingUser.getBorrowedList());
            // return success message
            return existingUser.getName() + " has successfully checked out " + existingBook.getTitle() + "!";
        }
        // else
        else{
            // throw illegal state exception saying book is unavailable
            throw new IllegalStateException(existingBook.getTitle() + " is currently unavailable.");
        }
    }

    public String returnBook(String userId, String bookId){
        Optional <User> user = userService.findUser(userId);
        Optional <Book> book = bookService.findBookById(bookId);

        // determine if user and book exists
        if(user.isEmpty()){
            throw new IllegalArgumentException("User ID " + userId + " not found.");
        }
        if(book.isEmpty()){
            throw new IllegalArgumentException("Book ID " + bookId + " not found.");
        }

        User existingUser = user.get();
        Book existingBook = book.get();

        boolean removed = existingUser.getBorrowedList().removeIf(b -> b.getID().equals(existingBook.getID()));

        if(removed){
            bookService.findBookById(existingBook.getID()).ifPresent(b -> b.setAvailability(true));
            return existingUser.getName() + " has successfully returned " + existingBook.getTitle() + "!";
        } else {
            throw new IllegalStateException(existingBook.getTitle() + " was not borrowed by " + existingUser.getName());

        }

    }

}