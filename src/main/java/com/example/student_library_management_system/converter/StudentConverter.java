package com.example.student_library_management_system.converter;

import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.requestdto.StudentRequestDto;

public class StudentConverter {
    public static Student convertRequestDtoIntoStudentModel(StudentRequestDto studentRequestDto){
        return Student.builder().name(studentRequestDto.getName())
                .age(studentRequestDto.getAge())
                .email(studentRequestDto.getEmail())
                .mobile(studentRequestDto.getMobile())
                .gender(studentRequestDto.getGender()).build();  //Inline variable

      /*  Student student = Student.builder().name(studentRequestDto.getName())
                .age(studentRequestDto.getAge())
                .email(studentRequestDto.getEmail())
                .mobile(studentRequestDto.getMobile())
                .gender(studentRequestDto.getGender()).build();
        return student;*/

    }
}
