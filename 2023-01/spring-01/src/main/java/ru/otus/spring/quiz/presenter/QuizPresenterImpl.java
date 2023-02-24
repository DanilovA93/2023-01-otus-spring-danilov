package ru.otus.spring.quiz.presenter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import ru.otus.spring.quiz.pojo.Answer;
import ru.otus.spring.quiz.pojo.Question;

@RequiredArgsConstructor
public class QuizPresenterImpl implements QuizPresenter {

  @Override
  public void present(Question question) {
    System.out.println(question.getValue());

    List<Answer> answers = question.getAnswers();
    for (int i = 0; i < answers.size(); i++) {
      System.out.println(i + ". " + answers.get(i).getValue());
    }
  }

  @Override
  public void present(String str) {
    System.out.println(str);
  }
}
