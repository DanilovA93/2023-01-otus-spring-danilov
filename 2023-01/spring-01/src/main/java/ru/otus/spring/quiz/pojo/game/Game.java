package ru.otus.spring.quiz.pojo.game;

import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import ru.otus.spring.quiz.pojo.user.User;

@Getter
@Setter
public class Game {

  private final User player;
  private final List<Question> questions;
  private int result;
  private int currentIndex;

  public Game(User user, List<Question> questions) {
    this.player = user;
    this.questions = questions;
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
