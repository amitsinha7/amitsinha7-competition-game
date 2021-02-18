package com.competition.game.webservices.api.v1;

public class RextesterResponse {

	private String result;
	private String warnings;
	private String errors;
	private String stats;
	private String files;
	private String notLoggedIn;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getWarnings() {
		return warnings;
	}

	public void setWarnings(String warnings) {
		this.warnings = warnings;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getNotLoggedIn() {
		return notLoggedIn;
	}

	public void setNotLoggedIn(String notLoggedIn) {
		this.notLoggedIn = notLoggedIn;
	}

	@Override
	public String toString() {
		return "RextesterResponse [result=" + result + ", warnings=" + warnings + ", errors=" + errors + ", stats="
				+ stats + ", files=" + files + ", notLoggedIn=" + notLoggedIn + "]";
	}

}
