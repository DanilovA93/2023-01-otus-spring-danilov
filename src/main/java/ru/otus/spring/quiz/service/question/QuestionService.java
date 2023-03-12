package ru.otus.spring.quiz.service.question;

import java.util.List;
import ru.otus.spring.quiz.pojo.game.Question;

public interface QuestionService {

  List<Question> getQuestions();

  boolean setAnswer(Question question, int answerIndex);
}
