package com.codingdojo.projectmanager.repositories;

import com.codingdojo.projectmanager.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long> {

    List<Task> findAll();
    List<Task> findByProjectTasksIdIs(Long id);


}
