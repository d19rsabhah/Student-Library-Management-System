package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converter.BookConverter;

import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.repository.AuthorRepository;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public String saveBooks(BookRequestDto bookRequestDto){
        Book book = BookConverter.convertRequestDtoIntoBookModel(bookRequestDto);

        // we find the author details with the id and set it inside the book
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);

        bookRepository.save(book);

        return "book details are saved in the database!";

    }


    public List<Book> getAllBoooks(){
        return bookRepository.findAll();
    }
}
