package com.example.task.domain;

public class TaskFactory implements ITaskFactory {
    @Override
    public Task createTask(Importance importance) {
        if (importance.equals(Importance.IMPORTANT)) {
            Task.TaskBuilder taskBuilder = new Task.TaskBuilder();
            return taskBuilder.title(Importance.IMPORTANT).build();
        } else {
            Task.TaskBuilder taskBuilder = new Task.TaskBuilder();
            return taskBuilder.title(Importance.REGULAR).build();
        }
    }
}
