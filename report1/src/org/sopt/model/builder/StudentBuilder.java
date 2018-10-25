package org.sopt.model.builder;

import org.sopt.model.Student;

public class StudentBuilder {
    private int idx;
    private String name;
    private int year;
    private String department;
    private String email;
    private String address;
    private int age;
    private int status;


    public StudentBuilder setIdx(int idx) {
        this.idx = idx;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public StudentBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setStatus(int status) {
        this.status = status;
        return this;
    }

    public Student build() {
        return new Student(this.idx, this.name, this.year, this.department, this.email, this.address, this.age, this.status);
    }
}
