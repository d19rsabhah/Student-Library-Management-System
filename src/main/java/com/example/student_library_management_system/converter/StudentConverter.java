package com.example.student_library_management_system.converter;

import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.requestdto.StudentRequestDto;

public class StudentConverter {
    public static Student convertRequestDtIntoStudentModel(StudentRequestDto studentRequestDto){
        Student student = Student.builder().name(studentRequestDto.getName())
                .age(studentRequestDto.getAge())
                .email(studentRequestDto.getEmail())
                .mobile(studentRequestDto.getMobile())
                .gender(studentRequestDto.getGender()).build();
        return student;
    }
}
