package com.example.bookshop.service;

import com.example.bookshop.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();
    Optional<Book> getBook(Long id);
    Book addBook(Long bookId, String title, String author, String genre);
    void updateBook(Long bookId, String title, String author, String genre);
    void deleteBook(Long bookId);

}
