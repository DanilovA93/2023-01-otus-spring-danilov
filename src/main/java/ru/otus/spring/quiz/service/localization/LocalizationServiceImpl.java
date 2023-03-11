package ru.otus.spring.quiz.service.localization;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.quiz.config.ApplicationProperties;

@Service
@RequiredArgsConstructor
public class LocalizationServiceImpl implements LocalizationService {

  private final ApplicationProperties applicationProperties;
  private final MessageSource messageSource;

  @Override
  public String localize(String code, String... params) {
    return messageSource.getMessage(code, params, applicationProperties.getLocale());
  }
}
