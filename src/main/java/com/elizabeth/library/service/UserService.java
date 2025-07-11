package com.elizabeth.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elizabeth.library.model.Book;
import com.elizabeth.library.model.Library;
import com.elizabeth.library.model.User;

@Service
public class UserService{
    private final Library library;

    // constructors
    public UserService(Library library){
        this.library = library;
    }

    // find all users
    public List<User> findUsers(){
        return new ArrayList<>(library.getBookDB().keySet());
    }

    // find a specific user
    public Optional<User> findUser(String id){
        return library.getBookDB().keySet().stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    // save user
    public User saveUser(User user){
        if(!library.getBookDB().containsKey(user)){
            library.getBookDB().put(user, user.getBorrowedList());
        }
        return user;
    }

    public Optional<User> updateUser(String id, User updated){
        Optional<User> searchUser = findUser(id);
        if(searchUser.isPresent()){
            User existingUser = searchUser.get();
            existingUser.setName(updated.getName());
            existingUser.setBorrowedList(updated.getBorrowedList());
            return Optional.of(existingUser);
        }
        return Optional.empty();
    }

    public boolean deleteUser(String id){
        Optional<User> deletingUser = findUser(id);
        if(deletingUser.isPresent()){
            User deleted = deletingUser.get();
            library.getBookDB().remove(deleted);
            return true;
        }
        return false;
    }

    public List<Book> FindBorrowedBooksByUser(String id){
        Optional<User> searching = findUser(id);
        return searching.map(User :: getBorrowedList).orElse(new ArrayList<>());
    }

}

