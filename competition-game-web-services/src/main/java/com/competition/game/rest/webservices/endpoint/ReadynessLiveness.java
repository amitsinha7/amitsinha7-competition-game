package com.competition.game.rest.webservices.endpoint;

import java.util.Collections;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class ReadynessLiveness {

	@ApiOperation(value = "Readiness for Competition Game Application", hidden = true, code = HttpStatus.SC_OK, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value = "ready")
	public Map<String, String> ready() {
		return Collections.singletonMap("response", "App is ready");
	}

	@ApiOperation(value = "Healthiness of Competition Game Application", hidden = true, code = HttpStatus.SC_OK, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value = "health")
	public Map<String, String> health() {
		return Collections.singletonMap("response", "App is up and running");
	}
}
