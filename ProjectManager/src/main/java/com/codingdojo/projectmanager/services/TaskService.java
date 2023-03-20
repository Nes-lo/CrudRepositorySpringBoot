package com.codingdojo.projectmanager.services;

import com.codingdojo.projectmanager.model.Task;
import com.codingdojo.projectmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskReposiroty;


    public TaskService(TaskRepository taskReposiroty) {
        this.taskReposiroty = taskReposiroty;
    }

    public List<Task> allTasks(){
        return taskReposiroty.findAll();
    }

    public List<Task> projectTasks(Long projectId){
       return taskReposiroty.findByProjectTasksIdIs(projectId);
    }

    public Task addTask(Task task) {
        return taskReposiroty.save(task);
    }

    public void deleteTask(Task task) {
        taskReposiroty.delete(task);
    }
}
