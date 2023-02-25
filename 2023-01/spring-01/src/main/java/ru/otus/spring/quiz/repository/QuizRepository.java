package ru.otus.spring.quiz.repository;

import java.util.List;
import ru.otus.spring.quiz.pojo.game.Game;
import ru.otus.spring.quiz.pojo.game.Question;

public interface QuizRepository {
  List<Question> getContent();

  void saveGame(Game game);

  Game getGame();
}
