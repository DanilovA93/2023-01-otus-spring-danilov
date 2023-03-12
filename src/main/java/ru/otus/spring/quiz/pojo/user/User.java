package ru.otus.spring.quiz.pojo.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class User {

  private final String firstName;
  private final String lastName;

  public String getFullName() {
    return firstName + " " + lastName;
  }
}
