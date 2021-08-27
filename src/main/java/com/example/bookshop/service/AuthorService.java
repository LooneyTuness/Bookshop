package com.example.bookshop.service;

import com.example.bookshop.model.Author;

import java.util.Date;
import java.util.Optional;

public interface AuthorService {

    Author addAuthor(Long authorId, String fname, String lname, Date dateOfBirth);

    Optional<Author> getAuthor(Long authorId);
}
