package ru.otus.spring.quiz.interractor;

import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.spring.quiz.pojo.user.User;
import ru.otus.spring.quiz.presenter.Presenter;

@Component
@RequiredArgsConstructor
public class InteractorImpl implements Interactor {

  private final Presenter presenter;

  public User getUser() {
    Scanner in = new Scanner(System.in);

    presenter.present("common.input.first-name");
    String firstName = in.nextLine();

    presenter.present("common.input.last-name");
    String lastName = in.nextLine();

    return new User(firstName, lastName);
  }

  public int getAnswerIndex() {
    Scanner in = new Scanner(System.in);
    presenter.present("common.input.answer");
    return in.nextInt();
  }
}
