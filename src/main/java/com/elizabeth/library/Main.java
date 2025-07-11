package com.elizabeth.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.elizabeth.library.model.Book;
import com.elizabeth.library.model.Library;
import com.elizabeth.library.model.User;

public class Main {

    public static void main(String[] args) {
        // initialize user and book instances
        User user = new User("Default User", new ArrayList<>());
        Book book = new Book("Default Title", "Default Author", true);
        int option = -1;

        // sample library
        List<Book> sampleBooks = new ArrayList<>();
        sampleBooks.add(new Book("To Kill a Mockingbird", "Harper Lee", true));
        sampleBooks.add(new Book("1984", "George Orwell", true));
        sampleBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", true));
        sampleBooks.add(new Book("Pride and Prejudice", "Jane Austen", true));
        sampleBooks.add(new Book("The Hobbit", "J.R.R. Tolkien", true));
        sampleBooks.add(new Book("The Catcher in the Rye", "J.D. Salinger", true));
        sampleBooks.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", true));
        sampleBooks.add(new Book("Harry Potter and the Sorcerers Stone", "J.K. Rowling", true));
        sampleBooks.add(new Book("The Chronicles of Narnia", "C.S. Lewis", true));
        sampleBooks.add(new Book("Frankenstein", "Mary Shelley", true));

        Library library = new Library(sampleBooks, new HashMap<>());
        LibrarySystem system = new LibrarySystem(book, user, library);
        // need a scanner
        Scanner choice = new Scanner(System.in);

        do {
            // display menu
            system.display();

            System.out.println("Your name: ");
            user.setName(choice.nextLine());
            System.out.println("Your Choice: ");
            option = choice.nextInt();
            choice.nextLine();

            // switch case
            switch (option) {
                // 1
                case 1:
                    System.out.println("Title of Book: ");
                    book.setTitle(choice.nextLine());
                    System.out.println("Name of Author: ");
                    book.setAuthor(choice.nextLine());
                    system.search(book.getTitle(), book.getAuthor());
                    system.borrow(user, book);

                    // borrow
                    break;

                // 2
                case 2:
                    System.out.println("Title of Book: ");
                    book.setTitle(choice.nextLine());
                    System.out.println("Name of Author: ");
                    book.setAuthor(choice.nextLine());
                    // return
                    system.returnBook(user, book);
                    break;

                // 3
                case 3:
                    System.out.println("Title of Book: ");
                    book.setTitle(choice.nextLine());
                    System.out.println("Name of Author: ");
                    book.setAuthor(choice.nextLine());
                    // search
                    system.search(book.getTitle(), book.getAuthor());
                    break;

                // default
                default:
                    System.out.println("GoodBye!\n");
                    return;
            }

        } while (option != 4);
        // while

        // scanner close
        choice.close();

    }
}
