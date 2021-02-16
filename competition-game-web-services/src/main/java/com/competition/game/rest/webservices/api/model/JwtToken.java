package com.competition.game.rest.webservices.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * JwtToken
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JwtToken {

	private static String jwtToken;

	public static String getJwtToken() {
		return jwtToken;
	}

	public static void setJwtToken(String jwtToken) {
		JwtToken.jwtToken = jwtToken;
	}

}
