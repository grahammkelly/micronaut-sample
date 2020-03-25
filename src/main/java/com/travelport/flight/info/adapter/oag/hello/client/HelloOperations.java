package com.travelport.flight.info.adapter.oag.hello.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import reactor.core.publisher.Mono;

public interface HelloOperations {
  Mono<String> getMono();
  Mono<String> getMonoWithName(String name);
}
