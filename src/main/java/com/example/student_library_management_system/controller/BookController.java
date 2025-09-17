package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.requestdto.BookRequestDto;
import com.example.student_library_management_system.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/api")
public class BookController {

    /*
    Loggers - displays the messages in console which helps in track the application flow
    different levels of loggers
    info - displays the information(general information are displayed)
    error - display error or exception messages
    warn - warning messages
    debug - while running in debug mode this will display
     */

    // declaring the loggers
    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public String saveBooks(@RequestBody BookRequestDto bookRequestDto){
        return bookService.saveBooks(bookRequestDto);
    }

    @GetMapping("/findAll")
    public List<Book> getAllBooks(){
        return bookService.getAllBoooks();
    }

    @GetMapping("/findPage")
    public List<Book> getAllBooksOnPagination(@RequestParam("pageno") int pageNo, @RequestParam("pagesize") int pageSize){
        return bookService.getBookPagination(pageNo,pageSize);
    }
    @GetMapping("/findSortedPage")
    public List<Book> getAllBooksOnSortedPages(@RequestParam("pageno") int pageNo, @RequestParam("pagesize") int pageSize, @RequestParam("sortparameter") String sortParameter){
        return bookService.getSortedPages(pageNo,pageSize, sortParameter);
    }

    @GetMapping("/findByTitle")
    public Book getBooksByTitle(@RequestParam("title") String title){
        return bookService.getBookByTitle(title);

    }

    @GetMapping("/findByGenre")
    public List<Book> getBooksByGenre(@RequestParam("genre") String genre){
        return bookService.getBookByGenre(genre);
    }

    @GetMapping("/findByTitleAndQuantity")
    public Book getBooksByTitleAndQuantity(@RequestParam("title") String title, @RequestParam("quantity") int quantity){
        return bookService.getTitleAndQuantity(title, quantity);
    }


//    @GetMapping("/findCustom")
//    public List<Book> findCustom(
//            @RequestParam String genre,
//            @RequestParam int minPages,
//            @RequestParam int quantity) {
//        return bookService.getCustomBooks(genre, minPages, quantity);
//    }



}
