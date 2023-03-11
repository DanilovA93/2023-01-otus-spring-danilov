package ru.otus.spring.quiz.repository.resource;

import org.springframework.core.io.Resource;

public interface ResourceRepository {
  Resource getContent();
}
