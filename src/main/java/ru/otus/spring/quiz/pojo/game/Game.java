package ru.otus.spring.quiz.pojo.game;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.otus.spring.quiz.pojo.user.User;

@Getter
@Setter
@EqualsAndHashCode
public class Game {

  private List<Question> questions;
  private User user;
  private int result;
  private int currentIndex;

  public Game() {
    this.result = 0;
    this.currentIndex = 0;
  }

  public int getTotal() {
    return questions.size();
  }

  public Question getCurrentQuestion() {
    return questions.get(currentIndex);
  }
}
