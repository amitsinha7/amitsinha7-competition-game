package com.competition.game.webservices.api.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RextesterResponse {

	@JsonProperty("Warnings") 
    public Object warnings;
    @JsonProperty("Errors") 
    public Object errors;
    @JsonProperty("Result") 
    public String result;
    @JsonProperty("Stats") 
    public String stats;
    @JsonProperty("Files") 
    public Object files;
    @JsonProperty("NotLoggedIn") 
    public boolean notLoggedIn;
	public Object getWarnings() {
		return warnings;
	}
	public void setWarnings(Object warnings) {
		this.warnings = warnings;
	}
	public Object getErrors() {
		return errors;
	}
	public void setErrors(Object errors) {
		this.errors = errors;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getStats() {
		return stats;
	}
	public void setStats(String stats) {
		this.stats = stats;
	}
	public Object getFiles() {
		return files;
	}
	public void setFiles(Object files) {
		this.files = files;
	}
	public boolean isNotLoggedIn() {
		return notLoggedIn;
	}
	public void setNotLoggedIn(boolean notLoggedIn) {
		this.notLoggedIn = notLoggedIn;
	}
	@Override
	public String toString() {
		return "RextesterResponse [warnings=" + warnings + ", errors=" + errors + ", result=" + result + ", stats="
				+ stats + ", files=" + files + ", notLoggedIn=" + notLoggedIn + "]";
	}
	public RextesterResponse(Object warnings, Object errors, String result, String stats, Object files,
			boolean notLoggedIn) {
		super();
		this.warnings = warnings;
		this.errors = errors;
		this.result = result;
		this.stats = stats;
		this.files = files;
		this.notLoggedIn = notLoggedIn;
	}
	public RextesterResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
