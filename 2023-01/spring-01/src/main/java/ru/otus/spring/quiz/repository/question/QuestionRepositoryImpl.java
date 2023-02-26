package ru.otus.spring.quiz.repository.question;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class QuestionRepositoryImpl implements QuestionRepository {

  private final String path;

  public QuestionRepositoryImpl(@Value("${quiz.file.path}") String path) {
    this.path = path;
  }

  @Override
  public Resource getContent() {
    return new ClassPathResource(path);
  }
}
