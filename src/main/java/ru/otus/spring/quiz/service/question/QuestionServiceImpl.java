package ru.otus.spring.quiz.service.question;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.repository.resource.ResourceRepository;
import ru.otus.spring.quiz.service.resource.question.QuestionResourceService;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

  private final QuestionResourceService questionResourceService;
  private final ResourceRepository resourceRepository;

  @Override
  public List<Question> getQuestions() {
    Resource resource = resourceRepository.getContent();
    return questionResourceService.getListOfQuestions(resource);
  }

  public boolean setAnswer(Question question, int answerIndex) {
    int minAnswerIndex = 0;
    int maxAnswerIndex = question.getAnswers().size() - 1;
    if (answerIndex < minAnswerIndex || answerIndex > maxAnswerIndex) {
      throw new RuntimeException(
          "Warning! index " + answerIndex + " is out of range " + minAnswerIndex + "..." + maxAnswerIndex
      );
    }

    return question.getAnswers().get(answerIndex).isRight();
  }
}
