package com.example.student_library_management_system.model;

import com.example.student_library_management_system.enums.BookGenre;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_title")
    private String title;
    //private String author;

    @Column(name = "total_pages")
    private int pages;

    @Column(name = "book_genre")
    @Enumerated(value = EnumType.STRING)
    private BookGenre genre;

    @Column(name = "quantity")
    private int quantity;

//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn
//    private Author author;
    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("booksWrittenByAuthor")  // prevent recursion
    private Author author;


    @JsonManagedReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transaction> transactionForBook  = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;

}
