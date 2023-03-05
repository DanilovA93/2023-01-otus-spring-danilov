package ru.otus.spring.quiz.interractor;

import ru.otus.spring.quiz.pojo.user.User;

public interface Interactor {
  User getUser();
  int getAnswerIndex();
}
