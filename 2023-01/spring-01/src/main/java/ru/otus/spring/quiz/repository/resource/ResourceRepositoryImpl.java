package ru.otus.spring.quiz.repository.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ResourceRepositoryImpl implements ResourceRepository {

  private final String path;

  public ResourceRepositoryImpl(@Value("${quiz.file.path}") String path) {
    this.path = path;
  }

  @Override
  public Resource getContent() {
    return new ClassPathResource(path);
  }
}
