package ru.otus.spring.quiz.service.resource;

import java.util.stream.Stream;
import org.springframework.core.io.Resource;

public interface ResourceService {
  Stream<String> getStreamOfStrings(Resource resource);
}
