package yncrea.pw04.service;

import yncrea.pw04.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findByLastname(String lastname);

    void saveStudent(Student student);

    List<Student> findAll();

    List<Student> findAllWithCourses();

    void deleteStudent(Long student);
}
