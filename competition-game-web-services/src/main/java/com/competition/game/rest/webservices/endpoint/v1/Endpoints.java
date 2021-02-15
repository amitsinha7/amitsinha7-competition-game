package com.competition.game.rest.webservices.endpoint.v1;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.competition.game.rest.webservices.api.model.v1.JwtToken;
import com.competition.game.rest.webservices.api.model.v1.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping()
@Api(value = "competition-game", protocols = "https,http", description = "API exposed by Competition Game Application")
public class Endpoints {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@ApiOperation(value = "Evaluate Competition Game Service", notes = "Use this to evalute the result score", response = Response.class, httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE, code = HttpStatus.SC_CREATED)
	@ApiResponses(value = {
			@ApiResponse(code = HttpStatus.SC_OK, message = "Competition task successfully received", response = Response.class),
			@ApiResponse(code = HttpStatus.SC_BAD_REQUEST, message = "Bad Request"),
			@ApiResponse(code = HttpStatus.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@PostMapping(value = "/v1/evaluates", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response evaluateChallenges(@RequestHeader(required = false, value = "Authorization") String token) {

		JwtToken.jwtToken = token;
		
		return new Response("Evaluated Challenges");
	}
}
