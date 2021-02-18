package com.competition.game.webservices.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * JwtToken
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class JwtToken {

	public static String jwtToken;

	public static String getJwtToken() {
		return jwtToken;
	}

	public static void setJwtToken(String jwtToken) {
		JwtToken.jwtToken = jwtToken;
	}

	@Override
	public String toString() {
		return "JwtToken []";
	}

}
