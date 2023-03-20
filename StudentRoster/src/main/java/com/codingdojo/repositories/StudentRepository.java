package com.codingdojo.repositories;

import com.codingdojo.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {

    List<Student> findAll();
    List<Student> findByBedroomId(Long bedroomId);

}
