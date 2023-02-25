package ru.otus.spring.quiz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/application.properties")
class ApplicationConfig {
}