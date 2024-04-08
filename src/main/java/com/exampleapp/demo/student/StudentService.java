package com.exampleapp.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

//@Component
@Service //this is same as saying it's a component but also specifies that it is also a service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addNewStudent(Student student){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        System.out.println(student);
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
        /*return List.of(
                new Student(
                        1L,
                        "Maya",
                        LocalDate.of(2000, Month.AUGUST, 23),
                        21,
                        "maya@gmail.com"
                )
        );*/
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + "does not exist");
        }
        studentRepository.deleteById(studentId);
    }
}
