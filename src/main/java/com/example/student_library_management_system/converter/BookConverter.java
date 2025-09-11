package com.example.student_library_management_system.converter;

import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.requestdto.BookRequestDto;

public class BookConverter {

    public static Book convertRequestDtoIntoBookModel(BookRequestDto bookRequestDto){

        return Book.builder().title(bookRequestDto.getBook_title())
                .pages(bookRequestDto.getTotal_pages())
                .genre(bookRequestDto.getGenre_type())
                .quantity(bookRequestDto.getQuantity())
                .build();
    }
}
