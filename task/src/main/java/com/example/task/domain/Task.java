package com.example.task.domain;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Importance title = Importance.REGULAR;
    @Lob
    private String description;

    public Task() {
        // To do nothing
    }

    public Task(Importance title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Importance getTitle() {
        return title;
    }

    public void setTitle(Importance title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Создаем builder

    public static class TaskBuilder {
        private final Task task = new Task();

        public TaskBuilder id(long id) {
            task.setId(id);
            return this;
        }

        public TaskBuilder title(Importance title) {
            task.setTitle(title);
            return this;
        }

        public TaskBuilder description(String description) {
            task.setDescription(description);
            return this;
        }

        public Task build() {
            return task;
        }
    }
}
