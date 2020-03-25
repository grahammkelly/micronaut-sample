package com.travelport.flight.info.adapter.oag.hello;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.travelport.flight.info.adapter.oag.hello.client.HelloClient;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.tracing.annotation.NewSpan;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import reactor.core.publisher.Mono;

@Controller("/hello")
@Slf4j
public class HelloController {
  @Inject
  HelloClient client;

  @Get(produces = MediaType.APPLICATION_JSON)
  @NewSpan
  public Mono<String> mono() {
    log.info("Base 'Hello' received by Mono");
    return client.getMonoWithName("World");
  }

  @Get(value = "/{name}", produces = MediaType.APPLICATION_JSON)
  @NewSpan
  public Mono<String> monoWithName(@PathVariable final String name) {
    final Optional<Map<String, String>> ctx = Optional.ofNullable(MDC.getCopyOfContextMap());
    log.info("Hello to {} received by Mono. Context contains {} entries", name, ctx.orElse(new HashMap()).size());
    return Mono.just("Hello " + name);
  }
}
