package ru.otus.spring.quiz.service.localization;

public interface LocalizationService {
  String localize(String code, String... params);
}
