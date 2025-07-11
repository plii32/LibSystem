package com.elizabeth.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elizabeth.library.model.Book;
import com.elizabeth.library.model.User;
import com.elizabeth.library.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController{
    // fields
    private final UserService userService;

    // constructor
    public UserController(UserService userService){
        this.userService = userService;
    }

    // GET request for finding specific user
    @GetMapping("/{user}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        Optional <User> user = userService.findUser(id);
        return user.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET request for finding all users
    @GetMapping
    public List<User> getAllUsers(){
        return userService.findUsers();
    }

    // POST request for adding user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/{user}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @PathVariable User user){
        Optional<User> username = userService.updateUser(id, user);
        return username.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{user}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

    @GetMapping("/search")
    public List<Book> searchBorrowedBooks(@PathVariable(required = false) String id){
        return userService.FindBorrowedBooksByUser(id);
    }

    
}