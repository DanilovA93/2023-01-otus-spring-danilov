package ru.otus.spring.quiz.interractor;

import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.spring.quiz.pojo.game.Game;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.pojo.user.User;
import ru.otus.spring.quiz.presenter.QuizPresenter;
import ru.otus.spring.quiz.service.QuizService;

@Component
@RequiredArgsConstructor
public class QuizInteractorImpl implements QuizInteractor {

  private final QuizService quizService;
  private final QuizPresenter presenter;

  @Override
  public void playGame() {
    createGame();
    User user = createUser();
    startGame(user);
  }

  private void createGame() {
    quizService.createGame();
  }

  private User createUser() {
    Scanner in = new Scanner(System.in);

    presenter.present("Enter your first name: ");
    String firstName = in.nextLine();

    presenter.present("Enter your last name: ");
    String lastName = in.nextLine();

    return new User(firstName, lastName);
  }

  private void startGame(User user) {

    Scanner in = new Scanner(System.in);
    Game game = new Game(user);

    while (quizService.nextQuestion() != null) {
      Question question = quizService.nextQuestion();

      presenter.present(question);

      game.getQuestions().add(question);

      int index = in.nextInt();
      boolean answerIsRight = quizService.setAnswer(index);

      if(answerIsRight) {
        game.setResult(game.getResult() + 1);
        presenter.present("Right!");
      } else {
        presenter.present("Wrong!");
      }

      quizService.saveGame(game);
    }

    createGameOverMessage(game);
  }

  private void createGameOverMessage(Game game) {
    presenter.present(
        game.getPlayer().getFullName()
            + " your result is: "
            + game.getResult() + "/" + game.getTotal()
    );
  }
}
