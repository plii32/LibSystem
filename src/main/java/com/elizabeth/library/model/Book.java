package com.elizabeth.library.model;

import java.util.UUID;

public class Book {

    // adding ids
    private String id;
    private String title;
    private String author;
    private boolean IsAvailable;

    // constructor for existing books
    public Book(String id, String title, String author, boolean IsAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.IsAvailable = IsAvailable;
    }

    // constructor for new books
    public Book(String title, String author, boolean IsAvailable){
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.IsAvailable = IsAvailable;
    }

    // accessor
    public String getID(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getAvailability() {
        return IsAvailable;
    }

    // mutator
    public void setID(String newId){
        this.id = newId;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void setAvailability(boolean newAvailability) {
        this.IsAvailable = newAvailability;
    }
}
