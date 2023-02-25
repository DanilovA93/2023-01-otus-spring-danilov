package ru.otus.spring.quiz.repository.game;

import ru.otus.spring.quiz.pojo.game.Game;

public interface GameRepository {
  void save(Game game);
  Game get();
}
