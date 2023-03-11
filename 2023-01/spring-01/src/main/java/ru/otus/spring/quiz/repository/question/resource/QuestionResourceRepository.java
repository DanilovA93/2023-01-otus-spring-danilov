package ru.otus.spring.quiz.repository.question.resource;

import org.springframework.core.io.Resource;

public interface QuestionResourceRepository {
  Resource getContent();
}
