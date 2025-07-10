
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    // declare variables
    Book book1, book2, book3;
    LibrarySystem libsystem;
    User user;
    Library library;

    @BeforeEach
    public void setUp() {
        // set up books
        List<Book> books = new ArrayList<>();
        book1 = new Book("The Hunger Games", "Suzanne Collins", true);
        book2 = new Book("1984", "George Orwell", true);
        book3 = new Book("Harry Potter and the Sorcerer Stone", "J.K. Rowling", false);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        // set up library
        library = new Library(books, new HashMap<>());

        // set up user
        user = new User("Test User", new ArrayList<>());

        // set up library system
        libsystem = new LibrarySystem(new Book("Dumb", "Stupid", true), new User("Vomit", new ArrayList<>()), library);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("-----TEAR DOWN COMMENCING----");
        System.setOut(System.out);
    }

    @Test
    public void searchAvailability() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        libsystem.search("The Hunger Games", "Suzanne Collins");
        assertTrue(out.toString().contains("The Hunger Games by Suzanne Collins found!"), "Search should be successful and displayed to user.");
    }

    @Test
    public void searchUnavailability() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        libsystem.search("Harry Potter and the Sorcerer Stone", "J.K. Rowling");
        assertFalse(out.toString().contains("Book not found."), "Search should fail and displayed to user.");
    }

    // return 
    @Test
    public void testReturnBook() {
        libsystem.borrow(user, book1);
        // capture output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        // return function
        libsystem.returnBook(user, book1);
        assertTrue(book1.getAvailability(), "Book should be marked as available in library after return.");
        // assert size of borrowed list is 0
        assertTrue(user.getBorrowedList().isEmpty(), "User's borrowed list should be empty after returning the book.");
    }

    @Test
    public void testReturnBookFail() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        libsystem.returnBook(user, book2);
        assertTrue(out.toString().contains("You currently have no books checked out."), "Attempt to return book should fail.");
    }

    @Test
    public void testBorrowBook() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        libsystem.borrow(user, book2);
        assertFalse(book2.getAvailability(), "The borrowed book should be shown as not available");
        assertTrue(!user.getBorrowedList().isEmpty(), "User borrowed book list has the added book");
        assertTrue(out.toString().contains("Checkout successful!"), "Attempt to checkout book was successful");
    }

    @Test
    public void testFailedBorrowBook() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        libsystem.borrow(user, book3);
        assertFalse(book3.getAvailability(), "This book should be shown as already unavailable");
        assertTrue(out.toString().contains("Sorry! Book not available."), "Unavailable message should be shown to user.");
    }
}
