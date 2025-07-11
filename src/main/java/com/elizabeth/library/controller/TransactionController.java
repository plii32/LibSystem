package com.elizabeth.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elizabeth.library.dto.BorrowRequest;
import com.elizabeth.library.dto.ReturnRequest;
import com.elizabeth.library.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController{
    // field 
    private final TransactionService transcationService;

    // constructor
    public TransactionController(TransactionService transactionService){
        this.transcationService = transactionService;
    }

    // POST request to borrow
    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(@RequestBody BorrowRequest request){
        try {
            String result = transcationService.borrowBook(request.getUserId(), request.getBookId());
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred" + e.getMessage());
        }
    }

    // POST request for return
    @PostMapping("/return")
    public ResponseEntity<String> returnBook(@RequestBody ReturnRequest request){
        try {
            String result = transcationService.returnBook(request.getUserId(), request.getBookId());
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred" + e.getMessage());

        }
    }
}