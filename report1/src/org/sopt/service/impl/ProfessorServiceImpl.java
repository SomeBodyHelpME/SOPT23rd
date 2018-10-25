package org.sopt.service.impl;

import org.sopt.model.Professor;
import org.sopt.model.builder.ProfessorBuilder;
import org.sopt.service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {

    @Override
    public Professor getByProfessorIdx(int ProfessorIdx) {
        final ProfessorBuilder professorBuilder = new ProfessorBuilder();
        final Professor professor = professorBuilder
                .setIdx(1)
                .setName("이상은")
                .setPhone("010-1234-5678")
                .setSubject("Server")
                .build();
        return professor;
    }
}
