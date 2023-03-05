package ru.otus.spring.quiz.repository.game;

import org.springframework.stereotype.Component;
import ru.otus.spring.quiz.pojo.game.Game;

@Component
public class GameRepositoryImpl implements GameRepository {

  private Game game;

  @Override
  public void save(Game game) {
    this.game = game;
  }

  @Override
  public Game get() {
    return this.game;
  }
}
