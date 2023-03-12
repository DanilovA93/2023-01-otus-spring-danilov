package ru.otus.spring.quiz.service.game;

public interface GameService {

  void setUser(String firstName, String lastName);

  void getQuestion();

  void setAnswer(int index);

  void restart();

  void quit();
}
