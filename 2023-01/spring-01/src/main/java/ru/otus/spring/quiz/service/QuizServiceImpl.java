package ru.otus.spring.quiz.service;

import java.util.LinkedList;
import lombok.RequiredArgsConstructor;
import ru.otus.spring.quiz.pojo.Question;
import ru.otus.spring.quiz.repository.QuizRepository;

@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

  private final LinkedList<Question> questions = new LinkedList<>();
  private Question currentQuestion = null;

  private final QuizRepository repository;

  @Override
  public void createGame() {
    questions.addAll(repository.getContent());
  }

  @Override
  public Question nextQuestion() {
    this.currentQuestion = questions.peek();
    return currentQuestion;
  }

  public boolean setAnswer(int index) {
    if (index < 0 || index > currentQuestion.getAnswers().size() - 1) {
      return false;
    }

    questions.poll();

    return currentQuestion.getAnswers().get(index).isRight();
  }
}
