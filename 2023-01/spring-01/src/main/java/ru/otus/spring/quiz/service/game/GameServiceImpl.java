package ru.otus.spring.quiz.service.game;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.quiz.interractor.Interactor;
import ru.otus.spring.quiz.pojo.game.Game;
import ru.otus.spring.quiz.pojo.user.User;
import ru.otus.spring.quiz.presenter.Presenter;
import ru.otus.spring.quiz.repository.game.GameRepository;
import ru.otus.spring.quiz.service.question.QuestionService;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

  private final QuestionService questionService;
  private final Presenter presenter;
  private final GameRepository repository;
  private final Interactor interactor;

  @PostConstruct
  private void init() {
    repository.setQuestions(questionService.getQuestions());
  }

  @Override
  public void setUser(String firstName, String lastName) {
    repository.setUser(new User(firstName, lastName));
  }

  @Override
  public void getQuestion() {
    presenter.present(repository.getGame().getCurrentQuestion());
  }

  @Override
  public void setAnswer(int index) {
    Game game = repository.getGame();

    try {
      boolean answerIsRight = questionService.setAnswer(game.getCurrentQuestion(), index);
      if(answerIsRight) {
        game.setResult(game.getResult() + 1);
      }

      game.setCurrentIndex(game.getCurrentIndex() + 1);

      if (checkGameIsFinished(game)) {
        finishTheGame(game);
      }

    } catch (Exception e) {
      throw new RuntimeException("Bad index");
    }
  }

  @Override
  public void restart() {
    repository.dropProgress();
  }

  private boolean checkGameIsFinished(Game game) {
    return game.getCurrentIndex() > game.getTotal() - 1;
  }

  private void finishTheGame(Game game) {
    presenter.presentResult(game);
    interactor.askUserToQuitOrRestart(
        () -> System.exit(0),
        this::restart
    );
  }
}
