package ru.otus.spring.quiz.repository.game;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring.quiz.pojo.game.Game;

@SpringBootTest
public class GameRepositoryImplUnitTest {

  @Autowired
  private GameRepositoryImpl gameRepository;
  private Game game;

  @BeforeEach
  public void before() {
    game = new Game();
    game.setCurrentIndex(5);
    game.setResult(5);
  }

  @Test
  public void dropProgress() {

    gameRepository.setGame(game);

    gameRepository.dropProgress();

    Game result = gameRepository.getGame();
    Assert.assertEquals(result.getCurrentIndex(), 0);
    Assert.assertEquals(result.getResult(), 0);
  }

}