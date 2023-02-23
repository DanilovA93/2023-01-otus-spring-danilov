package ru.otus.spring.quiz.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.otus.spring.quiz.pojo.Question;
import ru.otus.spring.quiz.util.ResourceUtil;

@RequiredArgsConstructor
public class QuizRepositoryImpl implements QuizRepository {

  private final String path;

  @Override
  public List<Question> getContent() {
    Resource resource = new ClassPathResource(path);
    return ResourceUtil.asQuestionList(resource);
  }
}
