package com.example.restfulapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService( StudentRepository studentRepository ){
        this.studentRepository =studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent( Student student ) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail( student.getEmail() );
        if ( studentOptional.isPresent() ) {
            throw new IllegalStateException("Student Already Exists!");
        }

        studentRepository.save(student);
    }
    public void deleteStudent (Long studentId ) {

        //True = studentRepository.existsById( studentId )
        if ( studentRepository.existsById( studentId ) ) {
            studentRepository.deleteById( studentId );
        }
        else {
            throw new IllegalStateException("Student Cannot Be Found");
        }
    }

    public void updateStudent( Long studentId, String name, String email, LocalDate dob) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student not found"));
        student.setName(name);
        student.setEmail(email);
        student.setDob(dob);
    }
}
