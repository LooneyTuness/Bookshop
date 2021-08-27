package com.example.bookshop.web.controller;

import com.example.bookshop.model.Author;
import com.example.bookshop.service.AuthorService;
import com.example.bookshop.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @PostMapping(value = "/authors")
    public Author addAuthor(Long authorId, String fname, String lname, Date dateOfBirth){
        return authorService.addAuthor(authorId,fname,lname,dateOfBirth);
    }

    @GetMapping(path = "authors/{authorId}")
    public Optional<Author> getAuthor(@PathVariable("authorId") Long authorId) {
        return authorService.getAuthor(authorId);
    }

}
