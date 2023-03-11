package ru.otus.spring.quiz.presenter;

import ru.otus.spring.quiz.pojo.game.Game;
import ru.otus.spring.quiz.pojo.game.Question;

public interface Presenter {
  void present(Question question);
  void present(String str);
  void presentResult(Game game);
}
