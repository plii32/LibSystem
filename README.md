# 📚 LibSystem: Java Console Library System
This is a simple, command-line interface (CLI) application for managing a small library. It allows users to borrow, return, and search for books within a predefined collection.

**✨ Features**
* Borrow Books: Users can borrow available books by specifying the title and author.
Return Books: Users can return books they have previously borrowed.
Search Books: Find books by title and author to check their availability.
Basic User Management: Track which user is performing operations.
Simple Console Interface: Easy interaction via text-based prompts.

**🚀 How to Run**
To get this project up and running on your local machine, follow these steps:

*Prerequisites*
Java Development Kit (JDK): Ensure you have JDK 8 or higher installed. You can download it from Oracle's website or use a package manager like SDKMAN! or Homebrew.

*Setup and Compilation*
Clone the Repository:

```git clone https://github.com/your-username/your-repo-name.git```

```cd your-repo-name/LibrarySystem```

(Replace https://github.com/your-username/your-repo-name.git with your actual repository URL)

Compile the Java Files:
Open your terminal or command prompt in the LibrarySystem directory and compile all the Java source files:

```javac *.java```

This command will compile Main.java, Book.java, User.java, Library.java, and LibrarySystem.java into .class files.

Execution
After successful compilation, run the Main class to start the application:

```java Main```

**📖 Usage**
Once the application starts, you will be presented with a menu. Follow the prompts to interact with the library system.

Example Interaction
--- Library Menu ---
1 - Borrow a Book
2 - Return a Book
3 - Search for a Book
4 - Quit
--------------------
Your Choice: 1
Enter your name: Alice
Title of Book to borrow: The Hobbit
Name of Author: J.R.R. Tolkien
Searching for: 'The Hobbit' by 'J.R.R. Tolkien'...
Book found: Title: 'The Hobbit', Author: 'J.R.R. Tolkien', Available: true
Alice successfully borrowed 'The Hobbit'.

--- Library Menu ---
1 - Borrow a Book
2 - Return a Book
3 - Search for a Book
4 - Quit
--------------------
Your Choice: 4
Goodbye!

**📂 Project Structure**
The project is organized into several Java classes, each with a specific responsibility:

Main.java:
The entry point of the application.
Handles the main program loop, displays the menu, takes user input, and orchestrates calls to the LibrarySystem methods.

Book.java:
Represents a single book with properties like title, author, and isAvailable (a boolean indicating if the book is currently on the shelf).
Provides constructors, getters, and setters for its properties.

User.java:
Represents a library user with a name and a borrowedList (a List of Book objects the user currently holds).
Includes methods to add and remove books from the user's borrowed list.

Library.java:

Manages the overall collection of books in the library.
Provides methods to add, remove, find, and retrieve all books.
Acts as the central repository for the library's inventory.

LibrarySystem.java:
Contains the core business logic for library operations.
Includes static methods for displaying the menu, searching for books, borrowing books, and returning books.
It interacts with Library and User objects to perform these operations.

**💡Future Enhancements**
Data Persistence: Implement saving and loading library data (books, borrowed status) to/from a file (e.g., CSV, JSON) or a database, so data is not lost when the application closes.
Advanced Search/Filter: Add more sophisticated search options (e.g., by genre, publication year) and filtering capabilities.
User Authentication: Implement a proper user login system.
Error Handling: More robust error handling for various user inputs and edge cases.
GUI: Develop a graphical user interface using Java Swing or JavaFX for a more user-friendly experience.
Loan Limits: Implement limits on the number of books a user can borrow.
