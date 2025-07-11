package com.elizabeth.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.elizabeth.library")
public class LibraryApplication{
    public static void main(String[] args){
        SpringApplication.run(LibraryApplication.class, args);
    }
}