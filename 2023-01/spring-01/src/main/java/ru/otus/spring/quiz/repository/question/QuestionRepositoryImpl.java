package ru.otus.spring.quiz.repository.question;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.util.ResourceUtil;

@Component
public class QuestionRepositoryImpl implements QuestionRepository {

  private final String path;

  public QuestionRepositoryImpl(@Value("${quiz.file.path}") String path) {
    this.path = path;
  }

  @Override
  public List<Question> getContent() {
    Resource resource = new ClassPathResource(path);
    return ResourceUtil.asQuestionList(resource);
  }
}
