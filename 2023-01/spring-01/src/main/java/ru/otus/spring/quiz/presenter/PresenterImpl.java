package ru.otus.spring.quiz.presenter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.spring.quiz.pojo.game.Answer;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.service.localization.LocalizationService;

@Component
@RequiredArgsConstructor
public class PresenterImpl implements Presenter {

  private final LocalizationService localizationService;

  @Override
  public void present(Question question) {
    present(question.getValue());

    List<Answer> answers = question.getAnswers();
    for (int i = 0; i < answers.size(); i++) {
      String localizedAnswer = localize(answers.get(i).getValue());
      print(i + ". " + localizedAnswer);
    }
  }

  @Override
  public void present(String str) {
    String localizedStr = localize(str);
    print(localizedStr);
  }

  @Override
  public void presentResult(String fullName, int result, int total) {
    String message = localize(
        "common.output.result",
        fullName, String.valueOf(result), String.valueOf(total)
    );

    print(message);
  }

  private void print(String str) {
    System.out.println(str);
  }

  private String localize(String code, String... params) {
    return localizationService.localize(code, params);
  }
}
