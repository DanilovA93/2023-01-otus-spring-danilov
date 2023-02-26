package ru.otus.spring.quiz.service.resource.question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.otus.spring.quiz.pojo.game.Answer;
import ru.otus.spring.quiz.pojo.game.Question;
import ru.otus.spring.quiz.service.resource.ResourceService;

@Service
@RequiredArgsConstructor
public class QuestionResourceServiceImpl implements QuestionResourceService {

  private final ResourceService resourceService;

  public List<Question> getListOfQuestions(Resource resource) {
    try {
      Stream<String> stringStream = resourceService.getStreamOfStrings(resource);

      List<Question> questions = new ArrayList<>();

      stringStream.forEach(line -> {
        String[] lineArray = line.split(",");

        if (!lineArray[0].isEmpty()) {
          questions.add(new Question(lineArray[0]));
        } else {
          questions.get(questions.size() - 1)
              .getAnswers().add(new Answer(lineArray[1], Boolean.parseBoolean(lineArray[2])));
        }
      });

      return questions;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
