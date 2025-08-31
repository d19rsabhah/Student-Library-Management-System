package com.example.student_library_management_system.requestdto;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private String author_name;
    private String author_country;
    private double author_rating;
    private int author_age;
    private String author_gender;
}
