package com.example.task;

import com.example.task.domain.TaskFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public TaskFactory productFactory() {
        return new TaskFactory();
    }
}
