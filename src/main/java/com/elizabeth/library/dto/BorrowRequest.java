package com.elizabeth.library.dto;

public class BorrowRequest{
    // fields
    private String userId;
    private String bookId;

    // default constructor
    public BorrowRequest(){}

    public BorrowRequest(String userId, String bookId){
        this.userId = userId;
        this.bookId = bookId;
    }

    // accessors
    public String getUserId(){
        return userId;
    }

    public String getBookId(){
        return bookId;
    }

    // mutators
    public void setUserId(String newId){
        this.userId = newId;
    }

    public void setBookId(String newBookId){
        this.bookId = newBookId;
    }
}