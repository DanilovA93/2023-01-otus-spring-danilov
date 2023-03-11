package ru.otus.spring.quiz.repository.question.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ru.otus.spring.quiz.repository.question.QuestionRepository;

@Component
public class QuestionResourceRepositoryImpl implements QuestionResourceRepository {

  private final String path;

  public QuestionResourceRepositoryImpl(@Value("${quiz.file.path}") String path) {
    this.path = path;
  }

  @Override
  public Resource getContent() {
    return new ClassPathResource(path);
  }
}
