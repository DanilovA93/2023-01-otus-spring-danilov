package ru.otus.spring.quiz.service;

import java.util.LinkedList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.quiz.pojo.game.Game;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.repository.QuizRepository;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

  private final QuizRepository repository;

  private final LinkedList<Question> questions = new LinkedList<>();
  private Question currentQuestion = null;

  @Override
  public void createGame() {
    questions.addAll(repository.getContent());
  }

  @Override
  public Question nextQuestion() {
    this.currentQuestion = questions.peek();
    return currentQuestion;
  }

  @Override
  public boolean setAnswer(int index) {
    if (index < 0 || index > currentQuestion.getAnswers().size() - 1) {
      return false;
    }

    questions.poll();

    return currentQuestion.getAnswers().get(index).isRight();
  }

  @Override
  public void saveGame(Game game) {
    repository.saveGame(game);
  }

  @Override
  public Game getGame() {
    return repository.getGame();
  }
}
