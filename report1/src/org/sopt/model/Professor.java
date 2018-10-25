package org.sopt.model;

public class Professor extends Department {
    private int idx;
    private String name;
    private String department;
    private String phone;
    private String subject;

    public Professor() {
    }

    public Professor(int idx, String name, String department, String phone, String subject) {
        this.idx = idx;
        this.name = name;
        this.department = department;
        this.phone = phone;
        this.subject = subject;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", phone='" + phone + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
