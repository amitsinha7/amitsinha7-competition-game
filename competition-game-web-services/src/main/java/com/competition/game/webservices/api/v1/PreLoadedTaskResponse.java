package com.competition.game.webservices.api.v1;

import java.util.List;

import com.competition.game.webservices.model.PreLoadedTask;

public class PreLoadedTaskResponse {

	private ErrorInfo errorInfo;

	private PreLoadedTask preLoadedTask;

	private List<PreLoadedTask> preLoadedTasks;

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	public PreLoadedTask getPreLoadedTask() {
		return preLoadedTask;
	}

	public void setPreLoadedTask(PreLoadedTask preLoadedTask) {
		this.preLoadedTask = preLoadedTask;
	}

	public List<PreLoadedTask> getPreLoadedTasks() {
		return preLoadedTasks;
	}

	public void setPreLoadedTasks(List<PreLoadedTask> preLoadedTasks) {
		this.preLoadedTasks = preLoadedTasks;
	}

}
