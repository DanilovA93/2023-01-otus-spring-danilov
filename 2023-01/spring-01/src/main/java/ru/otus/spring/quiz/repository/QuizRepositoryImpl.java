package ru.otus.spring.quiz.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ru.otus.spring.quiz.pojo.game.Game;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.util.ResourceUtil;

@Component
public class QuizRepositoryImpl implements QuizRepository {

  private final String path;
  private Game game;

  public QuizRepositoryImpl(@Value("${quiz.file.path}") String path) {
    this.path = path;
  }

  @Override
  public List<Question> getContent() {
    Resource resource = new ClassPathResource(path);
    return ResourceUtil.asQuestionList(resource);
  }

  @Override
  public void saveGame(Game game) {
    this.game = game;
  }

  @Override
  public Game getGame() {
    return this.game;
  }
}
