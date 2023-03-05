package ru.otus.spring.quiz.service.resource.question;

import java.util.List;
import org.springframework.core.io.Resource;
import ru.otus.spring.quiz.pojo.game.Question;

public interface QuestionResourceService {
  List<Question> getListOfQuestions(Resource resource);
}
