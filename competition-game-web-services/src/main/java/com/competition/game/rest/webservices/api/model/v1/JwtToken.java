package com.competition.game.rest.webservices.api.model.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * JwtToken. It's fetched from the service proxy API and it contains
 * information about the user.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class JwtToken {
	public static String jwtToken;
}
