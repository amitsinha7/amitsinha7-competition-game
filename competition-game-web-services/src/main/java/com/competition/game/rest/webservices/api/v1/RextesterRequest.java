package com.competition.game.rest.webservices.api.v1;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RextesterRequest {

	@NotNull
	@NotEmpty
	private String languageName;
	@NotNull
	@NotEmpty
	private String program;
	private String input;
	private String compilerArgs;

	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getCompilerArgs() {
		return compilerArgs;
	}

	public void setCompilerArgs(String compilerArgs) {
		this.compilerArgs = compilerArgs;
	}

	@Override
	public String toString() {
		return "RextesterReq [languageName=" + languageName + ", program=" + program + ", input=" + input
				+ ", compilerArgs=" + compilerArgs + "]";
	}

}
