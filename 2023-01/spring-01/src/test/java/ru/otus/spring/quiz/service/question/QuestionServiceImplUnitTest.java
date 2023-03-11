package ru.otus.spring.quiz.service.question;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.otus.spring.quiz.pojo.game.Answer;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.service.resource.question.QuestionResourceService;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceImplUnitTest {

  @Mock
  private QuestionResourceService questionResourceService;

  @InjectMocks
  private QuestionServiceImpl questionService;

  private List<Answer> answers;

  private Question question;

  @Before
  public void setUp() throws Exception {
    answers = List.of(
        new Answer("answer", false),
        new Answer("answer", true)
    );

    question = new Question("question", answers);
  }

  @Test
  public void throwExceptionOnBadIndexWhenSetAnswer() {

    Assert.assertThrows(
        Exception.class, () -> questionService.setAnswer(question, -1)
    );

    Assert.assertThrows(
        Exception.class, () -> questionService.setAnswer(question, answers.size())
    );
  }

  @Test
  public void returnFalseWhenSetAnswer() throws Exception {
    Assert.assertFalse(questionService.setAnswer(question, 0));
  }

  @Test
  public void returnTrueWhenSetAnswer() throws Exception {
    Assert.assertTrue(questionService.setAnswer(question, 1));
  }
}