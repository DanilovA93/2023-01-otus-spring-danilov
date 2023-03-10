package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.spring.quiz.service.game.GameService;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {

    ApplicationContext context = SpringApplication.run(Application.class);
    GameService gameService = context.getBean(GameService.class);
    gameService.play();
  }
}
