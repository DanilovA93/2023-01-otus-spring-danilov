package ru.otus.spring.quiz.service;

import ru.otus.spring.quiz.pojo.Question;

public interface QuizService {

  void createGame();

  Question nextQuestion();

  boolean setAnswer(int index);
}
