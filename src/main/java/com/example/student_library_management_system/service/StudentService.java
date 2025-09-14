package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converter.StudentConverter;
import com.example.student_library_management_system.enums.CardStatus;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.repository.StudentRepository;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public String saveStudents(StudentRequestDto studentRequestDto){
        Student student = StudentConverter.convertRequestDtoIntoStudentModel(studentRequestDto);

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);

        return "Student And Card Saved Successfully!";
    }

    public String deleteStudentById(int studentId){
        studentRepository.deleteById(studentId);
        return "Student deleted successfully.";
    }
}
