package ru.otus.spring.quiz.service.resource;

import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import ru.otus.spring.quiz.repository.resource.ResourceRepository;

@SpringBootTest
public class ResourceServiceImplTest {

  @Autowired
  private ResourceServiceImpl resourceService;

  @Autowired
  private ResourceRepository resourceRepository;

  @Test
  public void getStreamOfStrings() {
    Resource resource = resourceRepository.getContent();
    Stream<String> stream = resourceService.getStreamOfStrings(resource);
    Assert.assertNotNull(stream);
  }
}