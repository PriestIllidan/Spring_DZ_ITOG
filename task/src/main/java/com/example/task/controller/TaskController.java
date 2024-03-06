package com.example.task.controller;

import com.example.task.domain.Task;
import com.example.task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id) {
        Optional<Task> task = service.getTaskById(id);
        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public Task save(@RequestBody Task task) {
//        return service.saveOrUpdateTask(task);
//    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return service.saveOrUpdateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleete(@PathVariable Long id) {
        service.deleteTaskById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> create() {
        boolean isOk = service.createTask();
        if (isOk) {
            return ResponseEntity.ok(1);
        } else return ResponseEntity.ok(0);
    }
}
