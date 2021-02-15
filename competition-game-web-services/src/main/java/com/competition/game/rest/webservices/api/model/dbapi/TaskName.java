package com.competition.game.rest.webservices.api.model.dbapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TaskName {

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
	
	@JsonProperty("Node")
	NODE_JS()
}
