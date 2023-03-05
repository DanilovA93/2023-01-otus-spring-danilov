package ru.otus.spring.quiz.service.resource;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

  public Stream<String> getStreamOfStrings(Resource resource) throws IOException {
    Reader isr = new InputStreamReader(resource.getInputStream(), UTF_8);
    BufferedReader br = new BufferedReader(isr);
    return br.lines();
  }
}
