package org.sopt.model.builder;

import org.sopt.model.Professor;

public class ProfessorBuilder {
    private int idx;
    private String name;
    private String department;
    private String phone;
    private String subject;

    public ProfessorBuilder setIdx(int idx) {
        this.idx = idx;
        return this;
    }

    public ProfessorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProfessorBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }

    public ProfessorBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ProfessorBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Professor build() {
        return new Professor(this.idx, this.name, this.department, this.phone, this.subject);
    }
}
