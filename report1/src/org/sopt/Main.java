package org.sopt;

import org.sopt.model.Department;
import org.sopt.model.Professor;
import org.sopt.model.Student;
import org.sopt.model.University;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        final ArrayList<University> universityList = new ArrayList<>();

        final University university1 = new University();
        final University university2 = new University();
        final University university3 = new University();

        universityList.add(university1);
        universityList.add(university2);
        universityList.add(university3);

        final ArrayList<Department> departmentList = new ArrayList<>();

        final Department department1 = new Department();
        final Department department2 = new Department();
        final Department department3 = new Department();

        departmentList.add(department1);
        departmentList.add(department2);
        departmentList.add(department3);

        final ArrayList<Professor> professorList = new ArrayList<>();

        final Professor professor1 = new Professor();
        final Professor professor2 = new Professor();
        final Professor professor3 = new Professor();

        professorList.add(professor1);
        professorList.add(professor2);
        professorList.add(professor3);

        final ArrayList<Student> studentList = new ArrayList<>();

        final Student student1 = new Student();
        final Student student2 = new Student();
        final Student student3 = new Student();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        for (final University u : universityList) {
            System.out.println(u.toString());
        }
        for (final Department d : departmentList) {
            System.out.println(d.toString());
        }
        for (final Professor p : professorList) {
            System.out.println(p.toString());
        }
        for (final Student s : studentList) {
            System.out.println(s.toString());
        }

    }
}
