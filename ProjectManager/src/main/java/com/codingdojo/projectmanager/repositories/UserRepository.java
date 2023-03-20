package com.codingdojo.projectmanager.repositories;

import com.codingdojo.projectmanager.model.Project;
import com.codingdojo.projectmanager.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findAll();
    Optional<User> findByEmail(String email);
    User findByIdIs(Long id);
 //   List<User> findAllByProjects(Project project);
 //   List<User> findByProjectsNotContains(Project project);
}
