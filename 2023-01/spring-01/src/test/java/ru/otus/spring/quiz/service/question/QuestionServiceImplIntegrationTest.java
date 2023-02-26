package ru.otus.spring.quiz.service.question;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.otus.spring.SpringApplication;
import ru.otus.spring.quiz.pojo.game.Question;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringApplication.class)
public class QuestionServiceImplIntegrationTest {

  @Autowired
  private QuestionServiceImpl questionService;

  @Test
  public void returnQuestionsWhenGetQuestions() {
    List<Question> questions = questionService.getQuestions();
    Assert.assertEquals(questions.size(), 5);
  }
}