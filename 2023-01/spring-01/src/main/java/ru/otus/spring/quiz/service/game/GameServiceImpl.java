package ru.otus.spring.quiz.service.game;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.quiz.exception.GameException;
import ru.otus.spring.quiz.interractor.Interactor;
import ru.otus.spring.quiz.pojo.game.Game;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.pojo.user.User;
import ru.otus.spring.quiz.presenter.Presenter;
import ru.otus.spring.quiz.repository.game.GameRepository;
import ru.otus.spring.quiz.service.question.QuestionService;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

  private final QuestionService questionService;
  private final Presenter presenter;
  private final Interactor interactor;
  private final GameRepository repository;

  @Override
  public void play() {
    User user = interactor.getUser();
    List<Question> questions = questionService.getQuestions();
    start(new Game(user, questions));
  }

  private void start(Game game) {

    while (game.getQuestions().size() > game.getCurrentIndex()) {
      Question question = game.getCurrentQuestion();

      presenter.present(question);

      int answerIndex = interactor.getAnswerIndex();

      try {
        boolean answerIsRight = questionService.setAnswer(question, answerIndex);
        if(answerIsRight) {
          game.setResult(game.getResult() + 1);
        }

        game.setCurrentIndex(game.getCurrentIndex() + 1);

      } catch (GameException e) {
        continue;
      }
      repository.save(game);
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
