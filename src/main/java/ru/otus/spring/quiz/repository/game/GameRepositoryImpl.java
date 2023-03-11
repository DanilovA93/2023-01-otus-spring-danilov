package ru.otus.spring.quiz.repository.game;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.otus.spring.quiz.pojo.game.Game;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.pojo.user.User;

@Component
@Getter
@Setter
public class GameRepositoryImpl implements GameRepository {

  private Game game = new Game();

  @Override
  public void setUser(User user) {
    game.setUser(user);
  }

  @Override
  public void setQuestions(List<Question> questions) {
    game.setQuestions(questions);
  }

  @Override
  public void dropProgress() {
    game.setCurrentIndex(0);
    game.setResult(0);
  }
}
