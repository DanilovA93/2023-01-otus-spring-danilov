package ru.otus.spring.quiz.repository;

import java.util.List;
import ru.otus.spring.quiz.pojo.Question;

public interface QuizRepository {
  List<Question> getContent();
}
