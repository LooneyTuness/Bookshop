package com.example.bookshop.service.impl;

import com.example.bookshop.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock private BookRepository bookRepository;
    private BookServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest=new BookServiceImpl(bookRepository);
    }

    @Test
    void canGetAllBooks() {
        //when
        underTest.getAllBooks();
        //then
        verify(bookRepository).findAll();
    }


}