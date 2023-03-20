package com.codingdojo.services;

import com.codingdojo.models.Student;
import com.codingdojo.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> allStudents()
    {
        return studentRepository.findAll();
    }
    public List<Student> bedroomStudents(Long bedroomId){
        return studentRepository.findByBedroomId(bedroomId);
    }

    public  Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public void removeFromBedroom(Student student){
        student.setBedroom(null);
        studentRepository.save(student);
    }

    public Student findStudent(Long id){
        Optional<Student> optionalStudent=studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }
        return null;
    }
}
