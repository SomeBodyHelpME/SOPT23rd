package org.sopt.service.impl;

import org.sopt.model.Student;
import org.sopt.model.builder.StudentBuilder;
import org.sopt.service.StudentService;

public class StudentServiceImpl implements StudentService {

    @Override
    public Student getByStudentIdx(int StudentIdx) {
        final StudentBuilder studentBuilder = new StudentBuilder();
        final Student student = studentBuilder
                .setIdx(1)
                .setName("이상은")
                .setYear(1)
                .setDepartment("Server")
                .setEmail("Server")
                .setAddress("Server")
                .setAge(1)
                .setStatus(1)
                .build();
        return student;
    }
}