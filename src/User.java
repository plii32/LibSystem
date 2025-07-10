import java.util.List;
import java.util.Map;

public class User{
    private String name;
    private List<Book> borrowedList;

    // constructor
    public User(String name, List<Book> borrowedList){
        this.name = name;
        this.borrowedList = borrowedList;
    }

    // accessor
    public String getName(){
        return name;
    }

    public List<Book> getBorrowedList(){
        return borrowedList;
    }

    // mutator
    public void setName(String newName){
        this.name = newName;
    }

    public void setBorrowedList(List<Book> newBorrowedList){
        this.borrowedList = newBorrowedList;
    }
}