public class Book{
    private String title;
    private String author;
    private boolean IsAvailable;

    // constructor
    public Book(String title, String author, boolean IsAvailable){
        this.title = title;
        this.author = author;
        this.IsAvailable = IsAvailable;
    }

    // accessor
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public boolean getAvailability(){
        return IsAvailable;
    }

    // mutator
    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public void setAuthor(String newAuthor){
        this.author = newAuthor;
    }

    public void setAvailability(boolean newAvailability){
        this.IsAvailable = newAvailability;
    }
}