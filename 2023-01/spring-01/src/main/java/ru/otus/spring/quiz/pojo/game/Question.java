package ru.otus.spring.quiz.pojo.game;

import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Question {
  private final String value;
  private final List<Answer> answers;
}
