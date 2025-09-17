package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converter.BookConverter;

import com.example.student_library_management_system.enums.BookGenre;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.repository.AuthorRepository;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
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
    /*pagination api*/

    public List<Book> getBookPagination(int pageNumber, int pageSize) {
        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return bookPage.getContent(); // <-- get the actual books from the page
    }

    //arrenging the books based on ascending / descending order of the field
    public List<Book> getSortedPages(int pageNumber, int pageSize, String sortParameter) {
        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortParameter).ascending()));
        return bookPage.getContent(); // <-- get the actual books from the page
    }
    public Book getBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }
    //inputGenre
    public List<Book> getBookByGenre(String inputGenre){
        return bookRepository.findBooksByGenre(inputGenre);
    }

//    public List<Book> getCustomBooks(String genre, int minPages, int quantity) {
//        return bookRepository.findBooksByGenreAndPagesOrQuantity(genre, minPages, quantity);
//    }
    public Book getTitleAndQuantity(String title, int quantity){
        return bookRepository.findByTitleAndQuantity(title, quantity);
    }


}
