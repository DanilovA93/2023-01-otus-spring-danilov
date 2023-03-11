package ru.otus.spring.quiz.repository.resource;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceRepositoryImplTest {

  @Value("${test.val}")
  private String val;

  @Test
  public void returnQuestionsWhenGetQuestions() {
    Assert.assertEquals(1, 1);
    System.out.println(val);
  }
}