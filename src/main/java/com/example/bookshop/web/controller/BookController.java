package com.example.bookshop.web.controller;

import com.example.bookshop.model.Book;
import com.example.bookshop.service.BookService;
import com.example.bookshop.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path="books/{bookId}")
    public Optional<Book> getBook(@PathVariable("bookId") Long id){
        return bookService.getBook(id);
    }

    @PostMapping(value = "/add-books")
    public Book addBook(Long bookId, String title, String author, String genre){
        return bookService.addBook(bookId,title,author,genre);
    }

    @PutMapping(path = "books/{bookId}")
    public void updateBook(
            @PathVariable("bookId") Long bookId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String genre) {

        bookService.updateBook(bookId,title,author,genre);
    }

    @DeleteMapping(path = "books/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId){
        bookService.deleteBook(bookId);
    }
}
