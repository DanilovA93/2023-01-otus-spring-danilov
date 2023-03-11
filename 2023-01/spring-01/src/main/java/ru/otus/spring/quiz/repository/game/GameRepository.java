package ru.otus.spring.quiz.repository.game;

import java.util.List;
import ru.otus.spring.quiz.pojo.game.Game;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.pojo.user.User;

public interface GameRepository {
  void setGame(Game game);
  Game getGame();
  void setUser(User user);
  void setQuestions(List<Question> questions);
  void dropProgress();
}
