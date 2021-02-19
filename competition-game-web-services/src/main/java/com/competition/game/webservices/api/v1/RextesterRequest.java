package com.competition.game.webservices.api.v1;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RextesterRequest {

	@NotNull
	@NotEmpty
	private String username;
	@NotNull
	private int languageChoice;
	@NotNull
	@NotEmpty
	private String languageName;

	@NotNull
	@NotEmpty
	private String program;

	private String input;

	private String compilerArgs;

	public RextesterRequest() {
	}

	public RextesterRequest(@NotNull @NotEmpty String username, @NotNull int languageChoice,
			@NotNull @NotEmpty String languageName, @NotNull @NotEmpty String program, String input,
			String compilerArgs) {
		super();
		this.username = username;
		this.languageChoice = languageChoice;
		this.languageName = languageName;
		this.program = program;
		this.input = input;
		this.compilerArgs = compilerArgs;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLanguageChoice() {
		return languageChoice;
	}

	public void setLanguageChoice(int languageChoice) {
		this.languageChoice = languageChoice;
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compilerArgs == null) ? 0 : compilerArgs.hashCode());
		result = prime * result + ((input == null) ? 0 : input.hashCode());
		result = prime * result + languageChoice;
		result = prime * result + ((languageName == null) ? 0 : languageName.hashCode());
		result = prime * result + ((program == null) ? 0 : program.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RextesterRequest other = (RextesterRequest) obj;
		if (compilerArgs == null) {
			if (other.compilerArgs != null)
				return false;
		} else if (!compilerArgs.equals(other.compilerArgs))
			return false;
		if (input == null) {
			if (other.input != null)
				return false;
		} else if (!input.equals(other.input))
			return false;
		if (languageChoice != other.languageChoice)
			return false;
		if (languageName == null) {
			if (other.languageName != null)
				return false;
		} else if (!languageName.equals(other.languageName))
			return false;
		if (program == null) {
			if (other.program != null)
				return false;
		} else if (!program.equals(other.program))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RextesterRequest [username=" + username + ", languageChoice=" + languageChoice + ", languageName="
				+ languageName + ", program=" + program + ", input=" + input + ", compilerArgs=" + compilerArgs + "]";
	}

}
