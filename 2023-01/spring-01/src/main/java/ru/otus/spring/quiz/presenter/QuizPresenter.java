package ru.otus.spring.quiz.presenter;

import ru.otus.spring.quiz.pojo.Question;

public interface QuizPresenter {
  void present(Question question);
  void present(String str);
}
