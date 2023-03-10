package ru.otus.spring.quiz.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.quiz.service.game.GameService;

@ShellComponent
@RequiredArgsConstructor
public class GameShell {

  private final GameService gameService;

  @ShellMethod(
      key = {"u", "user"},
      value = "Set user name"
  )
  public void setUser(
      @ShellOption({"fn", "firstname"}) String firstName,
      @ShellOption({"ln", "lastname"}) String lastName
  ){
    gameService.setUser(firstName, lastName);
  }

  @ShellMethod(
      key = {"q", "get-question"},
      value = "Get next question"
  )
  public void getQuestion()
  {
    gameService.getQuestion();
  }

  @ShellMethod(
      key = {"a", "set-answer"},
      value = "Set answer"
  )
  public void setAnswer(
      @ShellOption({"index", "i"}) int index
  ){
    gameService.setAnswer(index);
  }

  @ShellMethod(
      key = {"restart"},
      value = "Restart game"
  )
  public void restart()
  {
    gameService.restart();
  }

  @ShellMethod(
      key = {"quit"},
      value = "Restart game"
  )
  public void quit()
  {
    gameService.restart();
  }
}
