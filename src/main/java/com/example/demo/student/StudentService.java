package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return this.studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = this.studentRepository.findByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Duplicate email present");
        }else{
            this.studentRepository.save(student);
        }
    }

    public void deleteStudentById(Long id) {
        if(this.studentRepository.existsById(id))
            this.studentRepository.deleteById(id);
        else
            throw new IllegalStateException("Student with ID " + id + " does not exist");

    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = this.studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("wrong id"));
        if(name != null && name.length() > 0 && !student.getName().equals(name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !student.getEmail().equals(email)){
            Optional<Student> studentOptional = this.studentRepository.findByEmail(email);
            if(studentOptional.isPresent())
                throw new IllegalStateException("email taken");
            else
                student.setEmail(email);
        }
    }
}
