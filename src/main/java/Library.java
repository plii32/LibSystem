import java.util.Map;
import java.util.List;

public class Library{
    private List<Book> books;
    private Map<User,List<Book>> bookDB;

    // constructor
    public Library(List<Book> books, Map<User, List<Book>> bookDB){
        this.books = books;
        this.bookDB = bookDB;
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
}