package com.example.student_library_management_system.model;

import com.example.student_library_management_system.enums.BookGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
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
}
