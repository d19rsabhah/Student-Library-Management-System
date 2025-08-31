package com.example.student_library_management_system.converter;

import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.requestdto.AuthorRequestDto;

public class AuthorConverter {
     public static Author convertRequestDtoIntoAuthorModel(AuthorRequestDto authorRequestDto){
         return Author.builder().author_name(authorRequestDto.getAuthor_name())
                 .country(authorRequestDto.getAuthor_country())
                 .rating(authorRequestDto.getAuthor_rating())
                 .age(authorRequestDto.getAuthor_age())
                 .gender(authorRequestDto.getAuthor_gender()).build();
     }
}
