package ru.otus.spring.quiz.service.question;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.quiz.exception.GameException;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.repository.question.QuestionRepository;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

  private final QuestionRepository repository;

  @Override
  public List<Question> getQuestions() {
    return repository.getContent();
  }

  public boolean setAnswer(Question question, int answerIndex) throws GameException {
    int minAnswerIndex = 0;
    int maxAnswerIndex = question.getAnswers().size() - 1;
    if (answerIndex < minAnswerIndex || answerIndex > maxAnswerIndex) {
      throw new GameException(
          "Warning! " + answerIndex + "out of range " + minAnswerIndex + "..." + maxAnswerIndex
          );
    }

    return question.getAnswers().get(answerIndex).isRight();
  }
}
