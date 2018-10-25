package org.sopt.model;

public class Student extends Department {
    private int idx;
    private String name;
    private int year;
    private String department;
    private String email;
    private String address;
    private int age;
    private int status;

    public Student() {
    }

    public Student(int idx, String name, int year, String department, String email, String address, int age, int status) {
        this.idx = idx;
        this.name = name;
        this.year = year;
        this.department = department;
        this.email = email;
        this.address = address;
        this.age = age;
        this.status = status;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}
