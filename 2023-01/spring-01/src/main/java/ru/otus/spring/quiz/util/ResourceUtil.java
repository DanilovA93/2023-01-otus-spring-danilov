package ru.otus.spring.quiz.util;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.LinkedList;
import org.springframework.core.io.Resource;
import ru.otus.spring.quiz.pojo.game.Answer;
import ru.otus.spring.quiz.pojo.game.Question;

public class ResourceUtil {

  public static LinkedList<Question> asQuestionList(Resource resource) {
    try (
        Reader isr = new InputStreamReader(resource.getInputStream(), UTF_8);
        BufferedReader br = new BufferedReader(isr)
    ) {
      LinkedList<Question> questions = new LinkedList<>();
      Question question = null;
      Answer answer = null;
      while (br.ready()) {
        String line = br.readLine();
        String[] lineArray = line.split(",");

        if (!lineArray[0].isEmpty()) {
          question = new Question(lineArray[0]);
          questions.add(question);
        } else if (question != null) {
          answer = new Answer(lineArray[1], Boolean.parseBoolean(lineArray[2]));
          question.getAnswers().add(answer);
        }
      }

      return questions;
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}
