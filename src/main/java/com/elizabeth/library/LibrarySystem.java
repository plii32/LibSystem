package com.elizabeth.library;
import com.elizabeth.library.model.Book;
import com.elizabeth.library.model.Library;
import com.elizabeth.library.model.User;


public class LibrarySystem {

    // fields
    private Book book;
    private User user;
    private Library library;

    // constructor
    public LibrarySystem(Book book, User user, Library library) {
        this.book = book;
        this.user = user;
        this.library = library;
    }

    // methods
    /**
     * Borrow function that allows user to check out book and updates the
     * library system
     *
     * @param user: user that is borrowing book
     * @param book: book that is being borrowed Returns boolean that indicates
     * if checkout was successful
     */
    public boolean borrow(User user, Book book) {
        // check if book is available
        if (!(book.getAvailability())) {
            // book not available
            System.out.println("Sorry! Book not available.");
            // return false
            return false;
        }

        // set book availability to false
        book.setAvailability(false);
        // add book to users borrowed book list
        user.getBorrowedList().add(book);
        // update bookDB?
        library.getBookDB().put(user, user.getBorrowedList());
        // say message
        System.out.println("Checkout successful!");
        // return true
        return true;
    }

    /**
     * Function that returns the checkout books back to the library
     *
     * @param user: user that is returning book
     * @param book: book that is being returned Returns boolean that signifies
     * that book return was successful
     */
    public boolean returnBook(User user, Book book) {
        // String newName = "N/A";
        // check user's borrow list
        if (user.getBorrowedList().size() > 0) {
            System.out.println("BorrowedList before: " + user.getBorrowedList());
            // set availability to true
            book.setAvailability(true);
            // remove book from users borrow list
            user.getBorrowedList().remove(book);
            System.out.println("BorrowedList after: " + user.getBorrowedList());
            // update bookDB
            library.getBookDB().remove(user.getName(), book);
            //library.getBookDB().put(newName, book);
            // say message
            System.out.println("Book return successful!");
            // return true
            return true;
        }
        // say that no book is borrowed from them
        System.out.println("You currently have no books checked out.");
        // return false
        return false;
    }

    /**
     * Search function that determines if a book exists
     *
     * @param title: title of book
     * @param author: author of book Returns boolean that shows if search was
     * successful or not
     */
    public Book search(String title, String author) {
        // loop through library db
        for (Book boo : library.getBooks()) {
            // check if title matches db element
            if (boo.getTitle().equalsIgnoreCase(title) && boo.getAuthor().equalsIgnoreCase(author)) {
                System.out.print(title + " by " + author + " found!\n");
                System.out.println("Here is the availability: " + (book.getAvailability() ? "Available" : "Not Available"));
                return boo;
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    public void display() {
        System.out.println("Welcome to the Library System");
        System.out.println("===================================");
        System.out.println("Options: ");
        System.out.println("1. Borrow a book\n2. Return a book\n3. Search for a book\n4. Exit");
    }
}
