package ru.otus.spring.quiz.service;

import ru.otus.spring.quiz.pojo.game.Game;
import ru.otus.spring.quiz.pojo.game.Question;

public interface QuizService {

  void createGame();

  Question nextQuestion();

  boolean setAnswer(int index);

  void saveGame(Game game);

  Game getGame();
}
