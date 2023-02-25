package ru.otus.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.spring.quiz.service.game.GameService;

@ComponentScan
public class SpringApplication {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringApplication.class);
    GameService gameService = context.getBean(GameService.class);
    gameService.play();
  }
}
