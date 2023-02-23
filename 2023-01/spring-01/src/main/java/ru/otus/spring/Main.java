package ru.otus.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.quiz.interractor.QuizInteractor;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
    QuizInteractor quizInteractor = context.getBean(QuizInteractor.class);
    quizInteractor.createGame();
    quizInteractor.playGame();
  }
}
