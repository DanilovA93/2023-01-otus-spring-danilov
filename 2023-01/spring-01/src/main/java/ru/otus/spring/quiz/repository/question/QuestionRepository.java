package ru.otus.spring.quiz.repository.question;

import java.util.List;
import ru.otus.spring.quiz.pojo.game.Question;

public interface QuestionRepository {

  void setQuestions(List<Question> questions);
  List<Question> getQuestions();
}
