package com.example.student_library_management_system.model;


import com.example.student_library_management_system.enums.AuthorRating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_country")
    private String country;

    @Column(name = "author_rating")
    @Enumerated(value = EnumType.STRING)
    private AuthorRating rating;

    @Column(name = "author_age")
    private int age;


}
