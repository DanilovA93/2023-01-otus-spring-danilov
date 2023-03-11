package ru.otus.spring.quiz.repository.question;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.otus.spring.quiz.pojo.game.Question;

@Component
@Getter
@Setter
public class QuestionRepositoryImpl implements QuestionRepository {

  private List<Question> questions = new ArrayList<>();
}
