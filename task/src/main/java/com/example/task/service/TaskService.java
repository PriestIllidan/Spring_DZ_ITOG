package com.example.task.service;

import com.example.task.domain.Importance;
import com.example.task.domain.Task;
import com.example.task.domain.TaskFactory;
import com.example.task.repository.ITaskRepository;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final ITaskRepository repository;

    @Autowired
    private TaskFactory taskFactory;

    public TaskService(ITaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    public Task saveOrUpdateTask(Task task) {
        return repository.save(task);
    }

    public void deleteTaskById(Long id) {
        repository.deleteById(id);
    }

    public boolean createTask() {
        boolean isOk = false;
        Task task = taskFactory.createTask(Importance.IMPORTANT);
        repository.save(task);
        if (task.getTitle().equals(Importance.IMPORTANT))
            isOk = true;
        return isOk;
    }
}