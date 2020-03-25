package com.travelport.flight.info.adapter.oag.hello.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import reactor.core.publisher.Mono;

@Client(value = "hello", path = "/hello")
@Retryable(multiplier = "2.0")
public interface HelloClient extends HelloOperations {
  @Get
  @Override
  Mono<String> getMono();

  @Get("/{name}")
  @Override
  Mono<String> getMonoWithName(@QueryValue String name);
}
