package com.example.bookshop.service.impl;

import com.example.bookshop.model.Book;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Long bookId, String title, String author, String genre) {
        Book book = new Book(bookId, title, author, genre);
        return bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Long bookId, String title, String author, String genre) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()->new IllegalStateException("book with id " + bookId + "does not exists"));

        if(title!=null && title.length() > 0 && !Objects.equals(book.getTitle(),title)){
            book.setTitle(title);
        }

        if(author!=null && author.length()>0 && !Objects.equals(book.getAuthor(),author)){
            book.setAuthor(author);
        }
        if(genre!=null && genre.length()>0 && !Objects.equals(book.getGenre(),genre)){
            book.setGenre(genre);
        }
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id " + bookId + "does not exists");
        }
        bookRepository.deleteById(bookId);
    }


}
