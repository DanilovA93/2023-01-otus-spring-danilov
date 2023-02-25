package ru.otus.spring.quiz.repository.question;

import java.util.List;
import ru.otus.spring.quiz.pojo.game.Game;
import ru.otus.spring.quiz.pojo.game.Question;

public interface QuestionRepository {
  List<Question> getContent();
}
