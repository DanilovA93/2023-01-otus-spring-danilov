package ru.otus.spring.quiz.interractor;

import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import ru.otus.spring.quiz.presenter.QuizPresenter;
import ru.otus.spring.quiz.service.QuizService;

@RequiredArgsConstructor
public class QuizInteractorImpl implements QuizInteractor {

  private final QuizService service;
  private final QuizPresenter presenter;

  @Override
  public void createGame() {
    service.createGame();
    presenter.present("Game created success!");
  }

  @Override
  public void playGame() {

    Scanner in = new Scanner(System.in);

    while (service.nextQuestion() != null) {
      presenter.present(service.nextQuestion());

      int index = in.nextInt();
      boolean answerIsRight = service.setAnswer(index);
      presenter.present(answerIsRight ? "Right!" : "Wrong!");
    }

    presenter.present("Game over!");
  }
}
