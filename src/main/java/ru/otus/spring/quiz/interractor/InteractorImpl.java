package ru.otus.spring.quiz.interractor;

import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.spring.quiz.presenter.Presenter;

@Component
@RequiredArgsConstructor
public class InteractorImpl implements Interactor {

  private final Presenter presenter;

  public void askUserToQuitOrRestart(
      Runnable quitAction,
      Runnable restartAction
  ){
    Scanner in = new Scanner(System.in);

    while (true) {
      presenter.present("common.output.endgame");
      String answer = in.nextLine();

      try {
        if (answer.equals("q")) {
          quitAction.run();
          break;
        }

        if (answer.equals("r")) {
          restartAction.run();
          break;
        }
      } catch (Exception e) {
        throw new RuntimeException("Catch exception while call callable");
      }
    }
  }
}
