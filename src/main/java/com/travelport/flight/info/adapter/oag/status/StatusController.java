package com.travelport.flight.info.adapter.oag.status;

import java.util.HashMap;
import java.util.Map;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;

@Controller("/status")
@Slf4j
public class StatusController {
  @Get(value = "/", produces = MediaType.APPLICATION_JSON)
  public Map<String, ? extends Object> getStatus() {
    final Map<String, String> statusMap = new HashMap<>();
    statusMap.put("status", "OK");

    log.info("Status request. Returning - {}", statusMap);
    return statusMap;
  }
}
