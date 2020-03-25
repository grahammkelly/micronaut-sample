package com.travelport.flight.info.adapter.oag.hello.client;

import io.micronaut.retry.annotation.Fallback;
import reactor.core.publisher.Mono;

@Fallback
public class HelloClientFallback implements HelloOperations {
  @Override public Mono<String> getMono() {
    return Mono.just("Hello World [fallback]");
  }

  @Override public Mono<String> getMonoWithName(String name) {
    return Mono.just("Hello " + name + " [fallback]");
  }
}
