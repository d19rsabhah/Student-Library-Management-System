package com.example.student_library_management_system.requestdto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentRequestDto { //don't want to directly interact with model class so we create this

    private String name;
    private int age;
    private String email;
    private String mobile;
    private String gender;

}
