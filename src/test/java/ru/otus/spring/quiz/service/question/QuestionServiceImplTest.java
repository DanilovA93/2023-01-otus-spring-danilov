package ru.otus.spring.quiz.service.question;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring.quiz.pojo.game.Question;

@SpringBootTest
public class QuestionServiceImplTest {

  @Autowired
  private QuestionServiceImpl questionService;

  @Test
  public void getQuestions() {
    List<Question> questions = questionService.getQuestions();
    Assertions.assertTrue(questions.size() > 1);
  }
}