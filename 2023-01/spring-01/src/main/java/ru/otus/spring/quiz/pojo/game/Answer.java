package ru.otus.spring.quiz.pojo.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Answer {
  private String value;
  private boolean right;
}
