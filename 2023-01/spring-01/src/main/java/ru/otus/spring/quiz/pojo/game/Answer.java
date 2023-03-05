package ru.otus.spring.quiz.pojo.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Answer {
  private final String value;
  private final boolean right;
}
