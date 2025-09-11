package com.example.student_library_management_system.requestdto;

import com.example.student_library_management_system.enums.BookGenre;
import lombok.Data;

@Data
public class BookRequestDto {
    private String book_title;
    private int total_pages;
    private BookGenre genre_type;
    private int quantity;
    private int cardId;
    private int authorId;

}
