package ru.otus.spring.quiz.repository.resource;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@DisplayName("Тест получения ресурсов")
public class ResourceRepositoryImplIntegrationTest {

  @Value("${quiz.file.path}")
  private String path;

  @Test
  @DisplayName("Проверка наличия ресурса")
  public void returnQuestionsWhenGetQuestions() {
    Resource resource = new ClassPathResource(path);
    Assert.assertTrue(resource.exists());
  }
}