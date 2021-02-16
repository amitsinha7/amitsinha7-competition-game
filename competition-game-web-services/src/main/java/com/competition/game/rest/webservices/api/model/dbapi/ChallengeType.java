package com.competition.game.rest.webservices.api.model.dbapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChallengeType {

	@JsonProperty("Java")
	JAVA(),

	@JsonProperty("JavaScript")
	JAVA_SCRIPT(),
	
	@JsonProperty(".Net")
	DOTNET(),

	@JsonProperty("Python")
	PYTHON(),

	@JsonProperty("C")
	C(),

}
