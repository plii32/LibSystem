package com.elizabeth.library.model;

import java.util.List;
import java.util.UUID;

public class User {

    // adding user ids
    private String id;
    private String name;
    private List<Book> borrowedList;

    // constructor for existing user
    public User(String id, String name, List<Book> borrowedList) {
        this.id = id;
        this.name = name;
        this.borrowedList = borrowedList;
    }

    // constructor for new user
    public User(String name, List<Book> borrowedList){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.borrowedList = borrowedList;
    }
    // accessor
    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedList() {
        return borrowedList;
    }

    // mutator
    public void setId(String newId){
        this.id = newId;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setBorrowedList(List<Book> newBorrowedList) {
        this.borrowedList = newBorrowedList;
    }

    @Override
    public String toString(){
        return "User " + id + ": " + name + "BorrowedList size: " +  borrowedList.size();
    }
}
