package com.example.bookshop.service.impl;

import com.example.bookshop.model.Author;
import com.example.bookshop.repository.AuthorRepository;
import com.example.bookshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Long authorId, String fname, String lname, Date dateOfBirth) {
        Author author = new Author(authorId,fname,lname,dateOfBirth);
        return authorRepository.save(author);
    }

    public Optional<Author> getAuthor(Long authorId) {
        return authorRepository.findById(authorId);
    }


}
